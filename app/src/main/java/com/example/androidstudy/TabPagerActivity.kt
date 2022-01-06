package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPagerActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_tab_pager)

		// 원하는 탭을 붙여줌
		tab_layout.addTab(tab_layout.newTab().setText("ONE"))
		tab_layout.addTab(tab_layout.newTab().setText("TWO"))
		tab_layout.addTab(tab_layout.newTab().setText("THREE"))

		val pagerAdapter = FragmentPagerAdapter(supportFragmentManager, 3)
		view_pager.adapter = pagerAdapter

		// tablayout과 pager를 연동
		tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
			override fun onTabSelected(tab: TabLayout.Tab?) {
				view_pager.currentItem = tab!!.position
			}

			override fun onTabUnselected(tab: TabLayout.Tab?) {
			}

			override fun onTabReselected(tab: TabLayout.Tab?) {
			}

		})

		// -> 페이저가 이동했을떄 탭을 이동시키는 코드
		view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
	}
}

// FragmentStatePagerAdapter가 depated 되어 수정 필요함
class FragmentPagerAdapter(
	fragmentManager: FragmentManager,
	val tabCount: Int,
) : FragmentStatePagerAdapter(fragmentManager) {
	override fun getCount(): Int {
		return tabCount
	}

	override fun getItem(position: Int): Fragment {
		return when (position) {
			0 -> {
				Fragment1()
			}
			1 -> {
				Fragment2()
			}
			2 -> {
				Fragment3()
			}
			else -> Fragment1()
		}
	}
}

