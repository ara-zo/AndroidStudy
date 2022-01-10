package com.example.androidstudy

import io.realm.RealmObject

/**
 * Created by arazo on 2022-01-10.
 */
open class School : RealmObject() {
	var name : String? = null
	var location : String? = null
}