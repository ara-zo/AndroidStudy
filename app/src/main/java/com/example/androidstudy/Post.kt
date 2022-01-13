package com.example.androidstudy

import java.io.Serializable

/**
 * Created by arazo on 2022-01-12.
 */
class Post(
	val owner: String? = null,
	val content: String? = null,
	val image: String? = null,
) : Serializable