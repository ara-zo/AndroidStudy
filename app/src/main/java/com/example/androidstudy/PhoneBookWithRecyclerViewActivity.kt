package com.example.androidstudy

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_phone_book_with_recycler_view.*

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_phone_book_with_recycler_view)

		var phoneBook = createFakePhoneBook(30)
		var phoneBookREcyclerAdapter = PhoneBookRecyclerAdapter(
														phonebookList = phoneBook,
														inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
														activity = this@PhoneBookWithRecyclerViewActivity
														)

		phonebook_recycler_view.adapter = phoneBookREcyclerAdapter
		phonebook_recycler_view.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)

		// 위의 내용을 줄여 쓴 코드
		//		with(phonebook_recycler_view) {
		//			this.adapter = PhoneBookRecyclerAdapter(
		//									phonebookList = createFakePhoneBook(30),
		//									inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
		//									activity = this@PhoneBookWithRecyclerViewActivity
		//								)
		//			this.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)
		//		}
	}

	fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
		for (i in 0 until fakeNumber) {
			phoneBook.addPerson(
				Person(name = "${i}번째 사람", number = "${i}번째 사람의 전화번호")
			)
		}
		return phoneBook
	}
}

class PhoneBookRecyclerAdapter(
	val phonebookList: PhoneBook,
	val inflater: LayoutInflater,
	val activity: Activity
) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>() {
	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val personName: TextView

		init {
			personName = itemView.findViewById(R.id.person_name)

			itemView.setOnClickListener {
//				val intent = Intent(activity, PhonebookDetail2Activity::class.java)
				val intent = Intent(activity, PhonebookDetail2Activity::class.java)
				intent.putExtra("name", phonebookList.personList[absoluteAdapterPosition].name)
				intent.putExtra("number", phonebookList.personList[absoluteAdapterPosition].number)
				activity.startActivity(intent)
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = inflater.inflate(R.layout.phonebook2_item, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.personName.text = phonebookList.personList[position].name
	}

	override fun getItemCount(): Int {
		return phonebookList.personList.size
	}
}