package com.example.androidstudy

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_shared_preference)

		save_btn.setOnClickListener {
			// SharedPreference 에 저장하는 방법
			val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)

			// Mode
			// - MODE_PRIVATE : 생성한 application에서만 사용 가능
			// - MODE_WORLD_READABLE : 다른 application 사용 가능 -> 읽을수만 있다
			// - MODE_WORLD_WRITEABLE : 다른 application 사용 가능 -> 기록도 가능
			// - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
			// - MODE_APPEND : 기존 preference에 신규로 추가

			// SharedPreference에 데이터를 넣어줌
			// 한번 저장을 하면 앱상에 계속 저장이 되어 있음
			val editor: SharedPreferences.Editor = sharedPreference.edit()
			editor.putString("hello", "안녕하세요")
			editor.putString("goodbye", "안녕히가세요")
			editor.commit()


			// sp1 -> Sharedpreference
			// 			(Key, Value) -> ("Hello", "안녕하세요")
			// sp2 -> Sharedpreference
			// 			(Key, Value) -> ("Hello", "안녕하세요11")
		}

		load_btn.setOnClickListener {
			// SharedPreference에 값을 불러오는 방법
			val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
			val value1 = sharedPreference.getString("hello", "데이터 없음1")
			val value2 = sharedPreference.getString("goodbye", "데이터 없음2")
			Log.d("key-value", "Value : $value1")
			Log.d("key-value", "Value : $value2")
		}

		delete_btn.setOnClickListener {
			val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
			val editor = sharedPreference.edit()
			// 특정키만 삭제
			editor.remove("hello")
			editor.commit()
		}

		delete_all_btn.setOnClickListener {
			val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
			val editor = sharedPreference.edit()
			// 모두 삭제
			editor.clear()
			editor.commit()
		}

	}
}