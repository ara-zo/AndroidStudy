package com.example.androidstudy.Kotlin

// 08. 제어 흐름

fun main(args: Array<String>) {
	val a: Int = 5
	val b: Int = 10

	// if/else 사용하는 방법 (1)
	println("if/else 사용하는 방법 (1)")
	if (a > b) {
		println("a가 b 보다 크다")
	} else {
		println("a가 b 보다 작다")
	}

	// if/else 사용하는 방법 (2)
	println("if/else 사용하는 방법 (2)")
	if (a > b) {
		println("a가 b 보다 크다")
	}

	if (a > b) {
		println("a가 b 보다 크다")
	} else if (a < b) {
		println("a가 b 보다 작다")
	} else {
		println("a가 b 보다 같다")
	}

	when {
		a > b -> {
			println("a가 b 보다 크다")
		}
		a < b -> {
			println("a가 b 보다 작다")
		}
		else -> {
			println("a가 b 보다 같다")
		}
	}

	// 값을 리턴하는 if 사용방법
	val max = if(a > b) {
		a
	} else {
		b
	}
	println()
	println(max)
}