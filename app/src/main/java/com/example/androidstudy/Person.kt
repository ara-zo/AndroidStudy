package com.example.androidstudy

import java.io.Serializable

/**
 * Created by arazo on 2022-01-10.
 */
class PersonFromServer(
	var id: Int? = null,
	var name: String? = null,
	var age: Int? = null,
	var intro: String? = null,
) : Serializable