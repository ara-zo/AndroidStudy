package com.example.androidstudy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Phonebook2Activity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_phonebook2)

		val phoneBook = createFakePhoneBook(30)
		createPhoneBookList(phoneBook)
	}

	fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
		for (i in 0 until fakeNumber) {
			phoneBook.addPerson(
				Person(name = "${i}번째 사람", number = "${i}번째 사람의 전화번호")
			)
		}
		return phoneBook
	}

	fun createPhoneBookList(phoneBook: PhoneBook) {
		val layoutInflater = LayoutInflater.from(this@Phonebook2Activity)
		val container = findViewById<LinearLayout>(R.id.phonebook_list_container)
		for(i in 0 until phoneBook.personList.size) {
			val view = layoutInflater.inflate(R.layout.phonebook2_item, null)
			val personNameView = view.findViewById<TextView>(R.id.person_name)
			personNameView.text = phoneBook.personList[i].name

			addSetOnClickListener(phoneBook.personList[i], view)
			container.addView(view)
		}
	}

	fun addSetOnClickListener(person: Person, view: View) {
		view.setOnClickListener {
			val intent = Intent(this@Phonebook2Activity, PhonebookDetail2Activity::class.java)
			intent.putExtra("name", person.name)
			intent.putExtra("number", person.number)
			startActivity(intent)
		}
	}
}

class PhoneBook() {
	// 전화번호부
	val personList = ArrayList<Person>()

	fun addPerson(person: Person) {
		personList.add(person)
	}
}

class Person(val name: String, var number: String) {

}