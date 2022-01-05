package com.example.androidstudy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*
import java.util.*

class RecyclerViewActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_recycler_view)

		val carList = ArrayList<CarForList>()
		for (i in 0 until 50) {
			carList.add(CarForList("${i}번째 자동차", "${i}순위 엔진"))
		}

		val adpater = RecyclerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity))
		recycler_view.adapter = adpater

		// 세로, 가로 스크롤
		recycler_view.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)

		// grid 스크롤
//		recycler_view.layoutManager = GridLayoutManager(this@RecyclerViewActivity, 2)
	}
}

class RecyclerViewAdapter(
	val itemList: ArrayList<CarForList>,
	val inflater: LayoutInflater,
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

	// onCreateViewHolder -> ViewHolder -> onBindViewHoleder

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val carName: TextView
		val carEngine: TextView

		// 초기화 블럭
		init {
			carName = itemView.findViewById(R.id.car_name)
			carEngine = itemView.findViewById(R.id.car_engin)

			itemView.setOnClickListener {
				val position: Int = absoluteAdapterPosition
				// inner class는 outer class의 변수에 접근할 수 없음
				// 접근하기 위해서 class 앞에 키워드 inner를 붙여줘야함
				// 이렇게 하면 ViewHolder class는 RecyclerViewAdapter class에 속하게 됨
				// outer class의 변수에 접근 가능해짐
				val engineName = itemList[position].engine
				Log.d("engine", engineName)
			}
		}
	}

	// view를 만들어줌
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = inflater.inflate(R.layout.item_view, parent, false)
		return ViewHolder(view)
	}

	// view를 그려주는 부분
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.carName.text = itemList[position].name
		holder.carEngine.text = itemList[position].engine
	}

	override fun getItemCount(): Int {
		return itemList.size
	}
}