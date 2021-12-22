package com.example.androidstudy.Kotlin

// 1) 사칙 연산을 수행할 수 있는 클래스



fun main(args: Array<String>) {
	val calculator1 = Calculator1()
	calculator1.plus(4, 5)
	calculator1.minus(4, 5)
	calculator1.multiply(4, 5)
	calculator1.division(4, 5)

	val calculator2 = Calculator2()
	calculator2.plus(1, 2, 3, 4, 5)
	calculator2.minus(5, 2)

	println()
	val calculator3 = Calculator3(3)
	calculator3.plus(5).minus(2 )

}

class Calculator1() {
	fun plus(a: Int, b: Int) {
		return println(a + b)
	}

	fun minus(a: Int, b: Int) {
		return println(a - b)
	}

	fun multiply(a: Int, b: Int) {
		return println(a * b)
	}

	fun division(a: Int, b: Int) {
		return println(a / b)
	}
}

class Calculator2() {
	fun plus(vararg numbers: Int) {
		var result = 0
		numbers.forEach {
			result += it
		}
		return println(result)
	}

	fun minus(vararg numbers: Int) {
		var result = 0
		numbers.forEachIndexed { index, num ->
			when (index) {
				0 -> result = num
				else -> result -= num
			}
		}
		return println(result)
	}

	fun multiply(vararg numbers: Int) {
		var result = 1
		numbers.forEach {
			result *= it
		}
		return println(result)
	}

	fun division(vararg numbers: Int) {
		var result = 1
		numbers.forEachIndexed { index, num ->
			when(index) {
				1 -> result = num
				else -> result /= num
			}
		}
		return println(result)
	}
}

class Calculator3(val initialValue: Int) {
	fun plus(number: Int): Calculator3 {
		val result = this.initialValue + number
		return Calculator3(result)
	}

	fun minus(number: Int): Calculator3 {
		val result = this.initialValue - number
		return Calculator3(result)
	}

	fun multiply(number:Int): Calculator3 {
		val result = this.initialValue * number
		return Calculator3(result)
	}

	fun division(number:Int): Calculator3 {
		val result = this.initialValue / number
		return Calculator3(result)
	}
}