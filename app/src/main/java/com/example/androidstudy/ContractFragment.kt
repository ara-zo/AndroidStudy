package com.example.androidstudy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class ContractFragment : Fragment() {

	private val itemList = mutableListOf<Contract>()

	interface  OnDataPassListener{
		fun onDataPass(data: Contract?)
	}

	lateinit var dataPassListener: OnDataPassListener


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)


	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View? {

		val view = inflater.inflate(R.layout.contract_fragment, container, false)

		for(i in 0 until 100) {
			itemList.add(i, Contract("홍길동${i}", "010-0000-000${i}", "mobile${i}"))
		}

		val listView = view.findViewById<LinearLayout>(R.id.list)

		for(i in 0 until itemList.size) {
			val phonebook_item = inflater.inflate(R.layout.phonebook_item, null)
			val name = phonebook_item.findViewById<TextView>(R.id.name)
			val icon = phonebook_item.findViewById<TextView>(R.id.icon)
			val phone_number = phonebook_item.findViewById<TextView>(R.id.phone_number)

			name.text = itemList[i].name
			icon.text = "H"
			phone_number.text = itemList[i].phoneNumber

			phonebook_item.setOnClickListener {

				val intent = Intent(activity, PhonebookDetailActivity::class.java)
				intent.apply {
					putExtra("name", itemList[i].name)
					putExtra("phoneNumber", itemList[i].phoneNumber)
					putExtra("mobileType", itemList[i].mobileType)
				}
				startActivity(intent)

			}

			listView.addView(phonebook_item)
		}



		return view
	}

}


class Contract(val name: String, val phoneNumber: String, val mobileType: String) {

}