package com.example.androidstudy

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_intent_test.*

class IntentTest : AppCompatActivity() {

	var regexp = "(https|http|ftp|telnet)://(.+)".toRegex()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_intent_test)

		btnOpen.setOnClickListener {
			var url = etUrl.text.toString()

			if (!url.matches(regexp)) {
				Log.d("url.matches", "not match")
				Toast.makeText(
					this.getApplicationContext(),
					"url을 정확히 작성해 주세요.(http(s):// 포함)",
					Toast.LENGTH_SHORT
				).show()
			} else {
				val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
				startActivity(intent)
			}
		}

		etUrl.addTextChangedListener(object : TextWatcher {
			// 텍스트가 변하고 난 후
			override fun afterTextChanged(s: Editable?) {
				Log.d("edit", "afterTextChanged : $s")
			}

			// 텍스트가 변하기 전
			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
				Log.d("edit", "beforeTextChanged : $s")
			}

			// 텍스트가 변하고 있을때
			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
				Log.d("edit", "onTextChanged : $s")
			}
		})
	}
}