package com.example.androidstudy

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.android.synthetic.main.activity_phonebook.*


class PhonebookActivity : AppCompatActivity() {

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.contact_appbar, menu)
		title = "Contracts"
		return true
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_phonebook)

		// 탭메뉴를 두번째로 변경
		tabLayout.getTabAt(1)?.select()

		var fragment: Fragment = ContractFragment()

		// 처음 프래그먼드 붙이기
		supportFragmentManager.beginTransaction().replace(R.id.contract_list, fragment).commit()

		tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
			override fun onTabSelected(tab: TabLayout.Tab) {
				fragment = when (tab.position) {
					0 -> FavoritesFragment()
					1 -> ContractFragment()
					else -> ContractFragment()
				}
				supportFragmentManager.beginTransaction().replace(R.id.contract_list, fragment).commit()
			}

			override fun onTabUnselected(tab: TabLayout.Tab) {
			}

			override fun onTabReselected(tab: TabLayout.Tab) {
			}
		})
	}
}


