package com.example.androidstudy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by arazo on 2022-01-06.
 */
class Fragment1 : Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View? {
		Log.d("life_cycle", "F onCreateView")

		// Fragment가 인터페이스를 처음으로 그릴때 호출됨
		// inflater -> 뷰를 그려주는 역할
		// container -> 부모뷰
		return inflater.inflate(R.layout.fragement_one, container, false)
	}
}