package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidstudy.Kotlin.num
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_calculator)

		var new = "0"
		var old = "0"
		var isFrist = true

		num1.setOnClickListener {
			new = when (new) {
				"0" -> "1"
				else -> new + "1"
			}
			answer.text = new
		}

		num2.setOnClickListener {
			new = when (new) {
				"0" -> "2"
				else -> new + "2"
			}
			answer.text = new
		}

		num3.setOnClickListener {
			new = when (new) {
				"0" -> "3"
				else -> new + "3"
			}
			answer.text = new
		}

		num4.setOnClickListener {
			new = when (new) {
				"0" -> "4"
				else -> new + "4"
			}
			answer.text = new
		}

		num5.setOnClickListener {
			new = when (new) {
				"0" -> "5"
				else -> new + "5"
			}
			answer.text = new
		}

		num6.setOnClickListener {
			new = when (new) {
				"0" -> "6"
				else -> new + "6"
			}
			answer.text = new
		}

		num7.setOnClickListener {
			new = when (new) {
				"0" -> "7"
				else -> new + "7"
			}
			answer.text = new
		}

		num8.setOnClickListener {
			new = when (new) {
				"0" -> "8"
				else -> new + "8"
			}
			answer.text = new
		}

		num9.setOnClickListener {
			new = when (new) {
				"0" -> "9"
				else -> new + "9"
			}
			answer.text = new
		}

		num0.setOnClickListener {
			new = when (new) {
				"0" -> "0"
				else -> new + "0"
			}
			answer.text = new
		}

		plus.setOnClickListener {
			old = (old.toInt() + new.toInt()).toString()
			new = "0"
			answer.text = old
		}
		minus.setOnClickListener {
			old = (old.toInt() - new.toInt()).toString()
			new = "0"
			answer.text = old
		}

		multiply.setOnClickListener {
			if(isFrist) {
				old = "1"
				isFrist = false
			}

			old = (old.toInt() * new.toInt()).toString()
			new = "0"

			answer.text = old
		}

		divide.setOnClickListener {
			if (isFrist) {
				old = new
				isFrist = false
			} else {
				old = when (new) {
					"0" -> "0"
					else -> (old.toInt() / new.toInt()).toString()
				}
				new = "0"
			}
			answer.text = old
		}

		ca.setOnClickListener {
			isFrist = true
			old = "0"
			new = "0"
			answer.text = "0"
		}
	}
}