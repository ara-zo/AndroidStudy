package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phonebook_detail2.*

class PhonebookDetail2Activity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_phonebook_detail2)

		getPersonInfoAndDraw()

		back.setOnClickListener {
			onBackPressed()
		}
	}

	fun getPersonInfoAndDraw(){
		val name = intent.getStringExtra("name")
		val number = intent.getStringExtra("number")

		person_detail_name.text = name
		person_detail_number.text = number
	}
}