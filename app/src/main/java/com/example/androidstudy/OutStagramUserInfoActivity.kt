package com.example.androidstudy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_out_stagram_post_list.*
import kotlinx.android.synthetic.main.activity_out_stagram_post_list.all_list
import kotlinx.android.synthetic.main.activity_out_stagram_post_list.my_list
import kotlinx.android.synthetic.main.activity_out_stagram_post_list.upload
import kotlinx.android.synthetic.main.activity_out_stagram_user_info.*

class OutStagramUserInfoActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_out_stagram_user_info)

		all_list.setOnClickListener {
			startActivity(Intent(this@OutStagramUserInfoActivity,
				OutStagramPostListActivity::class.java))
		}

		my_list.setOnClickListener {
			startActivity(Intent(this@OutStagramUserInfoActivity,
				OutStagramMyPostListActivity::class.java))
		}

		upload.setOnClickListener {
			startActivity(Intent(this@OutStagramUserInfoActivity,
				OutStagramUploadActivity::class.java))
		}

		logout.setOnClickListener {
			val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
			val editor = sp.edit()
			editor.putString("login_sp", null)
			editor.commit()
			(application as MasterApplication).createRetrofit()
			finish()
			startActivity(Intent(this@OutStagramUserInfoActivity, LoginActivity::class.java))
		}
	}
}