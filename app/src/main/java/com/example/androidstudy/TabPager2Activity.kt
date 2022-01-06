package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*
import kotlinx.android.synthetic.main.activity_tab_pager.tab_layout
import kotlinx.android.synthetic.main.activity_tab_pager.view_pager
import kotlinx.android.synthetic.main.activity_tab_pager2.*

class TabPager2Activity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_tab_pager)

		// 원하는 탭을 붙여줌
		tab_layout.addTab(tab_layout.newTab().setText("ONE"))
		tab_layout.addTab(tab_layout.newTab().setText("TWO"))
		tab_layout.addTab(tab_layout.newTab().setText("THREE"))

		val adpater = ThreePageAdapter(LayoutInflater.from(this@TabPager2Activity))
		view_pager.adapter = adpater
		view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

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

class ThreePageAdapter(
	val layoutInflater: LayoutInflater,
) : PagerAdapter() {

	// position에 해당하는 페이지 생성
	override fun instantiateItem(container: ViewGroup, position: Int): Any {
		when (position) {
			0 -> {
				val view = layoutInflater.inflate(R.layout.fragement_one, container, false)
				container.addView(view)
				return view
			}
			1 -> {
				val view = layoutInflater.inflate(R.layout.fragement_two, container, false)
				container.addView(view)
				return view
			}
			2 -> {
				val view = layoutInflater.inflate(R.layout.fragment_three, container, false)
				container.addView(view)
				return view
			}
			else -> {
				val view = layoutInflater.inflate(R.layout.fragement_one, container, false)
				container.addView(view)
				return view
			}
		}
	}

	// position 위치의 페이지 제거
	override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
		container.removeView(`object` as View)
	}

	// 사용가능한 뷰의 갯수를 리턴
	override fun getCount(): Int {
		return 3
	}

	// 페이지뷰가 특정 키 객체(key object)와 연관되는지 여부
	override fun isViewFromObject(view: View, `object`: Any): Boolean {
		// '==' : 주소값이 아닌 값 비교(동등성)
		// '===' : 주소값 비교(동일성) (좀더 정확한 비교)
		return view === `object` as View
	}
}