package com.example.androidstudy

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_async.*

class AsyncActivity : AppCompatActivity() {
	var task: BackgroundAsyncTask? = null
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_async)


		start.setOnClickListener {
			task = BackgroundAsyncTask(progressbar, ment)
			task?.execute()
		}
		stop.setOnClickListener {
//			task?.cancel(true)
			startActivity(Intent(this@AsyncActivity, Intent2::class.java))
		}
	}

	override fun onPause() {
		task?.cancel(true)
		super.onPause()
	}
}

class BackgroundAsyncTask(
	val progressbar: ProgressBar,
	val progressText: TextView,
) : AsyncTask<Int, Int, Int>() {
	// params -> doInBackground에서 사용할 타입
	// progress -> onProgressUpdate에서 사용할 타입
	// result -> onPostExecute에서 사용할 타입

	var percent: Int = 0

	override fun onPreExecute() {
		percent = 0
		progressbar.progress = 0
	}

	override fun doInBackground(vararg params: Int?): Int {
		while (!isCancelled()) {
			percent++
			Log.d("async", "value : $percent")
			if (percent > 100) {
				break
			} else {
				publishProgress(percent)
			}
			try {
				Thread.sleep(1000)
			} catch (e: Exception) {
				e.printStackTrace()
			}
		}
		return percent
	}

	override fun onProgressUpdate(vararg values: Int?) {
		progressbar.progress = values[0] ?: 0
		progressText.text = "퍼센트 : ${values[0]}"
		super.onProgressUpdate(*values)
	}

	override fun onPostExecute(result: Int?) {
		progressText.text = "작업이 완료 되었습니다."
		super.onPostExecute(result)
	}

	override fun onCancelled() {
		progressbar.progress = 0
		progressText.text = "작업이 취소되었습니다."

		super.onCancelled()
	}
}