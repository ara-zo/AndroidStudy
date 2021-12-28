package com.example.androidstudy

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class FragmentOne : Fragment() {
	override fun onAttach(context: Context) {
		Log.d("life_cycle", "F onAttach")
		super.onAttach(context)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		Log.d("life_cycle", "F onCreate")
		super.onCreate(savedInstanceState)
	}

	// view를 그림
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		Log.d("life_cycle", "F onCreateView")

		// Fragment가 인터페이스를 처음으로 그릴때 호출됨
		// inflater -> 뷰를 그려주는 역할
		// container -> 부모뷰
		return inflater.inflate(R.layout.fragement_one, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		Log.d("life_cycle", "F onViewCreated")
		super.onViewCreated(view, savedInstanceState)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		Log.d("life_cycle", "F onActivityCreated")
		super.onActivityCreated(savedInstanceState)
	}

	override fun onStart() {
		Log.d("life_cycle", "F onStart")
		super.onStart()
	}

	override fun onResume() {
		Log.d("life_cycle", "F onResume")
		super.onResume()
	}

	override fun onPause() {
		Log.d("life_cycle", "F onPause")
		super.onPause()
	}

	override fun onStop() {
		Log.d("life_cycle", "F onStop")
		super.onStop()
	}

	override fun onDestroy() {
		Log.d("life_cycle", "F onDestroy")
		super.onDestroy()
	}

	override fun onDetach() {
		Log.d("life_cycle", "F onDetach")
		super.onDetach()
	}
}