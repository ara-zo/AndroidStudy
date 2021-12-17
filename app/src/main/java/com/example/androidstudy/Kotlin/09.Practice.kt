package com.example.androidstudy.Kotlin

fun main(args: Array<String>) {
	val a: Int? = null
	val b: Int = 10
	val c: Int = 100

	if(a == null) {
		println("a is null")
	} else {
		println("a is not null")
	}

	if( b + c == 110) {
		println("b plus c is 110")
	} else {
		println("b plus c is not 110")
	}
}