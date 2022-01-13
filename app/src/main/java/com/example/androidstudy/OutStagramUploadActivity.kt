package com.example.androidstudy

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_out_stagram_upload.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class OutStagramUploadActivity : AppCompatActivity() {

	lateinit var filePath: String

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_out_stagram_upload)

		view_pictures.setOnClickListener {
			getPicture()
		}

		upload_post.setOnClickListener {
			if (filePath.isNotBlank()) {
				uploadPost()
			} else {
				Toast.makeText(this@OutStagramUploadActivity, "사진을 선택해 주세요.", Toast.LENGTH_SHORT)
					.show()
			}

		}

		all_list.setOnClickListener {
			startActivity(Intent(this@OutStagramUploadActivity,
				OutStagramPostListActivity::class.java))
		}

		my_list.setOnClickListener {
			startActivity(Intent(this@OutStagramUploadActivity,
				OutStagramMyPostListActivity::class.java))
		}

		user_info.setOnClickListener {
			startActivity(Intent(this@OutStagramUploadActivity,
				OutStagramUploadActivity::class.java))
		}

		val checkSelfPermission = ContextCompat.checkSelfPermission(
			this@OutStagramUploadActivity,
			android.Manifest.permission.READ_EXTERNAL_STORAGE,
		)

		if (checkSelfPermission != PackageManager.PERMISSION_GRANTED) {
			// 권한이 없는 경우
			ActivityCompat.requestPermissions(
				this@OutStagramUploadActivity,
				arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
				1000
			)
		} else {
			// 권한이 있는 경우
			Log.d("PERMISSION_GRANTED", "권한이 이미 있음")
		}

	}

	fun getPicture() {
		val intent = Intent(Intent.ACTION_PICK)
		intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
		intent.setType("image/*")
		startActivityForResult(intent, 1000)
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		if (requestCode == 1000) {
			val uri: Uri = data!!.data!!
			filePath = getImageFilePath(uri)
		}
	}

	// 절대경로를 알기 위함
	fun getImageFilePath(contentUri: Uri): String {
		// 인덱스를 적기 위한 변수
		var columnIndex = 0
		// media 이미지의 데이터를 걸러내겠다는 뜻
		val projection = arrayOf(MediaStore.Images.Media.DATA)
		// 어떤 인덱스를 가리키고 있는지 알려줌
		// contentResolver : 컨텐츠를 관리
		// .query() : 검색
		val cursor = contentResolver.query(contentUri, projection, null, null, null)
		if (cursor!!.moveToFirst()) {
			columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
		}
		return cursor.getString(columnIndex)
	}

	override fun onRequestPermissionsResult(
		requestCode: Int,
		permissions: Array<out String>,
		grantResults: IntArray,
	) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults)
		if (requestCode == 1000) {
			if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				// 승낙
				Log.d("permissionssss", "승낙")
			} else {
				// 거부
				Log.d("permissionssss", "거부")
			}
		}
	}

	fun uploadPost() {
		val file = File(filePath)
		val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file)
		val part = MultipartBody.Part.createFormData("image", file.name, fileRequestBody)
		val content = RequestBody.create(MediaType.parse("text/plain"), getContent())

		(application as MasterApplication).service.uploadPost(
			part, content
		).enqueue(object : Callback<Post> {
			override fun onResponse(call: Call<Post>, response: Response<Post>) {
				if (response.isSuccessful) {
					finish()
					startActivity(Intent(this@OutStagramUploadActivity, OutStagramPostListActivity::class.java))
				}
			}

			override fun onFailure(call: Call<Post>, t: Throwable) {
			}

		})

	}

	fun getContent(): String {
		return content_input.text.toString()
	}
}