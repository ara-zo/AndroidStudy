package com.example.androidstudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_phonebook_detail.*

class PhonebookDetailActivity : AppCompatActivity() {
	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		supportActionBar?.hide()
		return false
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_phonebook_detail)

		tvDetailName.text = intent.getStringExtra("name")

		val inflater = LayoutInflater.from(this@PhonebookDetailActivity)

		val itemView = inflater.inflate(R.layout.phonebook_detail_item, null)
		val tvPhoneNum = itemView.findViewById<TextView>(R.id.tvPhoneNum)
		val tvMobileType = itemView.findViewById<TextView>(R.id.tvMobileType)
		val tvClick = itemView.findViewById<TextView>(R.id.tvClick)

		tvPhoneNum.text = intent.getStringExtra("phoneNumber")
		tvMobileType.text = intent.getStringExtra("mobileType")

		tvClick.setOnClickListener {
			Toast.makeText(this@PhonebookDetailActivity, "클릭했음!!", Toast.LENGTH_LONG).show()
		}

		tvDetailItem.addView(itemView)

	}
}