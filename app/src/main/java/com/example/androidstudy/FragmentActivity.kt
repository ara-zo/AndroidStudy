package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {

	override fun onDataPass(data: String?) {
		Log.d("pass", data.toString())
	}

	override fun onCreate(savedInstanceState: Bundle?) {

		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_fragment)

		Log.d("life_cycle", "onCreate")

		val fragmentOne: FragmentOne = FragmentOne()
		// 프라그먼트에 data를 넣어주는 방법
		// 프라그먼트에 data를 넣을려면 bundle이라는 것을 만들어 줘야함
		val bundle: Bundle = Bundle()
		bundle.putString("hello", "hello")
		fragmentOne.arguments = bundle


		button.setOnClickListener {
			// 프라그먼트를 동적으로 작동하는 방법
			// 프라그머트 붙이는 방법 replace/add
			// supportFragmentmanager -> AppCompatActivity가 가지고 있음
			// supportFragmentmanager를 바로 쓸 수 있는 이유는 AppCompatActivity를 상속 받았기 때문이다.
			val fragmentManager: FragmentManager = supportFragmentManager

			// Transction
			// 작업의 단위 -> 시작과 끝이 있다
			// 시작
			val fragmentTransaction = fragmentManager.beginTransaction()
			// 할일
			fragmentTransaction.replace(R.id.container, fragmentOne)
			// 끝
			fragmentTransaction.commit()
			
			// 끝을 내는 방법
			// commit		-> 시간 될때 해 (좀더 안정적)
			// commitnow	-> 지금 당장해
		}


		button2.setOnClickListener {
			// 프라그먼트 remove/detach 하는 방법
			val fragmentManager = supportFragmentManager
			val fragmentTransaction = fragmentManager.beginTransaction()
			
			// remove와 detach의 차이점
			// remove의 경우 fragmentManager안에서 완전히 제거되지만 detach의 경우 stack에 존재
			// 추후 attach를 호출할 경우 다시 보여줄 수 있지만, View 계층에서 다시 생성되기 때문에
			// remove와 별 차이가 없어 보임
			fragmentTransaction.remove(fragmentOne)
			// fragmentTransaction.detach(fragmentOne)
			
			fragmentTransaction.commit()
		}
	}

	override fun onStart() {
		super.onStart()
		Log.d("life_cycle", "onStart")
	}

	override fun onResume() {
		super.onResume()
		Log.d("life_cycle", "onResume")
	}

	override fun onPause() {
		super.onPause()
		Log.d("life_cycle", "onPause")
	}

	override fun onStop() {
		super.onStop()
		Log.d("life_cycle", "onStop")
	}

	override fun onDestroy() {
		super.onDestroy()
		Log.d("life_cycle", "onDestroy")
	}

}