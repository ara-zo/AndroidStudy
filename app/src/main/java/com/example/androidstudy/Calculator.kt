package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_calculator)

		var new = ""
		var old = ""

		num1.setOnClickListener {
			new = when (new) {
				"" -> "1"
				else -> new + "1"
			}
			answer.text = new
		}

		num2.setOnClickListener {
			new = when (new) {
				"" -> "2"
				else -> new + "2"
			}
			answer.text = new
		}

		num3.setOnClickListener {
			new = when (new) {
				"" -> "3"
				else -> new + "3"
			}
			answer.text = new
		}

		num4.setOnClickListener {
			new = when (new) {
				"" -> "4"
				else -> new + "4"
			}
			answer.text = new
		}

		num5.setOnClickListener {
			new = when (new) {
				"" -> "5"
				else -> new + "5"
			}
			answer.text = new
		}

		num6.setOnClickListener {
			new = when (new) {
				"" -> "6"
				else -> new + "6"
			}
			answer.text = new
		}

		num7.setOnClickListener {
			new = when (new) {
				"" -> "7"
				else -> new + "7"
			}
			answer.text = new
		}

		num8.setOnClickListener {
			new = when (new) {
				"" -> "8"
				else -> new + "8"
			}
			answer.text = new
		}

		num9.setOnClickListener {
			new = when (new) {
				"" -> "9"
				else -> new + "9"
			}
			answer.text = new
		}

		num0.setOnClickListener {
			new = when (new) {
				"" -> "0"
				else -> new + "0"
			}
			answer.text = new
		}

		plus.setOnClickListener {
			old = (old.toInt() + new.toInt()).toString()
			new = ""
			answer.text = old
		}
		minus.setOnClickListener {
			old = (old.toInt() - new.toInt()).toString()
			new = ""
			answer.text = old
		}

		multiply.setOnClickListener {
			if(old == "") {
				old = "1"
			}

			if(new != "") {
				old = (old.toInt() * new.toInt()).toString()
			}

			new = ""

			answer.text = old
		}

		divide.setOnClickListener {

			Log.d("TAG", "divide")

			if(old == "") {
				old = new
				new = ""
			}

			if(old != "" && new != "")  {
				old = (old.toInt() / new.toInt()).toString()
			}

			new = ""

			answer.text = old
		}

		ca.setOnClickListener {
			old = ""
			new = ""
			answer.text = "0"
		}
	}
}