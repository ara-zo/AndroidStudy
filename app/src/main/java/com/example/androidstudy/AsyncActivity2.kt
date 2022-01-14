package com.example.androidstudy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_async.*
import kotlinx.android.synthetic.main.activity_fragment.view.*
import java.util.*
import java.util.concurrent.TimeUnit


class AsyncActivity2 : AppCompatActivity() {


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_async)

		Observable // 생산자 : 데이터를 생산하여 전달
			.just("Hello?", "RxJava!?") // 생성 연산자
			.map { it.dropLast(1) } // 변환 연산자 : 데이터의 가공 (뒷자리 하나 제거)
			.subscribe(::println) // 소비자 : 데이터를 받아서 처리 (println)

	}

}



