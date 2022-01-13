package com.example.androidstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_out_stagram_post_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OutStagramPostListActivity : AppCompatActivity() {

	lateinit var glide: RequestManager

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_out_stagram_post_list)

		glide = Glide.with(this)

		(application as MasterApplication).service.getAllPosts().enqueue(
			object : Callback<ArrayList<Post>> {
				override fun onResponse(
					call: Call<ArrayList<Post>>,
					response: Response<ArrayList<Post>>,
				) {
					if (response.isSuccessful) {
						val postList = response.body()
						val adpater = PostAdapter(postList!!,
							LayoutInflater.from(this@OutStagramPostListActivity),
							glide)
						post_recyclerview.adapter = adpater
						post_recyclerview.layoutManager =
							LinearLayoutManager(this@OutStagramPostListActivity)
					}
				}

				override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

				}
			}
		)

		user_info.setOnClickListener {
			startActivity(Intent(this@OutStagramPostListActivity,
				OutStagramUserInfoActivity::class.java))
		}

		my_list.setOnClickListener {
			startActivity(Intent(this@OutStagramPostListActivity,
				OutStagramMyPostListActivity::class.java))
		}

		upload.setOnClickListener {
			startActivity(Intent(this@OutStagramPostListActivity,
				OutStagramUploadActivity::class.java))
		}
	}
}

class PostAdapter(
	val postList: ArrayList<Post>,
	val inflater: LayoutInflater,
	val glide: RequestManager,
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val postOwner: TextView
		val postImage: ImageView
		val postContent: TextView

		init {
			postOwner = itemView.findViewById(R.id.post_owner)
			postImage = itemView.findViewById(R.id.post_img)
			postContent = itemView.findViewById(R.id.post_content)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = inflater.inflate(R.layout.outstagram_item_view, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.postOwner.text = postList[position].owner
		holder.postContent.text = postList[position].content
		glide.load(postList[position].image).into(holder.postImage)
	}

	override fun getItemCount(): Int {
		return postList.size
	}
}

