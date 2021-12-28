package com.example.androidstudy

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_intent.*
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent1 : AppCompatActivity() {

	lateinit var activityResultLauncher: ActivityResultLauncher<Intent>


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_intent)


		// 결과값 받기
		// startActivityForResult() deprecated 되어
		// registerForActivityResult을 사용
		activityResultLauncher =
			registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
				if (it.resultCode == RESULT_OK) {
					val result =
						it.data?.getIntExtra("result", 0)
					Log.d("number", "${it.resultCode}")
					Log.d("number", "$result")
				}

			}

		change_activity.setOnClickListener {
			// 명시적 인텐트
//			val intent = Intent(this@Intent1, Intent2::class.java)
//
//			// Key, Value 방식 -> Key와 value를 쌍으로 만들어 저장
//			intent.putExtra("number1", 1)
//			intent.putExtra("number2", 2)
//			startActivity(intent)


//			val intent2 = Intent(this@Intent1, Intent2::class.java)
//			// Apply ->
//			intent2.apply {
//				this.putExtra("number1", 1)
//				this.putExtra("number2", 0)
//			}
//			startActivity(intent2)

//			val intent3 = Intent(this@Intent1, Intent2::class.java)
//			intent3.apply {
//				this.putExtra("number1", 100)
//				this.putExtra("number2", 200)
//			}
//			activityResultLauncher.launch(intent3)

			// 암시적 인텐트
			val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com/"))
			startActivity(intent)
		}


	}


}