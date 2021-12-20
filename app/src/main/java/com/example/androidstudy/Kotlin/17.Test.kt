package com.example.androidstudy.Kotlin

fun main(args: Array<String>) {
	first()
	println(second(80))
	println(third(52))
	gugudan()
}

fun first() {
	val a = mutableListOf<Int>()
	val b = mutableListOf<Boolean>()

	for (i in 1..9) {
		a.add(i)
	}

	a.forEach { i ->
		val result = when (i % 2) {
			0 -> true
			else -> false
		}
		b.add(result)
	}

	println(a)
	println(b)
}

fun second(param: Int): String {
	return when (param) {
		in 90..100 -> "A"
		in 80..89 -> "B"
		in 70..79 -> "C"
		else -> "F"
	}
}

fun third(param: Int): Int {
	var result = 0

	param.toString().map { c ->
		result += Character.getNumericValue(c)
	}

	return result
}

fun gugudan() {
	println("구구단 시작")
	for (i in 1..9) {
		for (j in 1..9) {
			if (j == 1) {
				println("========== ${i}단 ===========")
			}
			println("$i * $j = ${i * j}")
		}
	}
}