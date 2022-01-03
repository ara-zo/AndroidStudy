package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_thread)

		// 쓰레드가 할일을 담아둠
		val runnable: Runnable = object : Runnable {
			override fun run() {
				Log.d("thread-1", "Thread1 is made")
			}
		}

		// 쓰레드 생성
		// 쓰레드 생성후 할일을 runnable에 담아 둠
		// 아직 쓰레드에 할일만 담아둔 상태
		val thread: Thread = Thread(runnable)

		button.setOnClickListener {
			// 쓰레드 실행
			thread.start()
		}


		// 쓰레드를 바로 실행시킬 경우
		// 1
		Thread(object : Runnable {
			override fun run() {
				Log.d("thread-1", "Thread2 is made")
			}
		}).start()

		// 2
		Thread(Runnable {
			Thread.sleep(2000) //-> 쓰레드가 실행되고 2초후에 로그가 실행
			Log.d("thread-1", "Thread3 is made")

			// ui쓰레드(main쓰레드)에서 변경
			runOnUiThread {
				button.setBackgroundColor(getColor(R.color.textview_color))
			}
		}).start()



	}
}