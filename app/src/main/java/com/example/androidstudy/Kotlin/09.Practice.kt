package com.example.androidstudy.Kotlin

fun main(args: Array<String>) {
	val a: Int? = null
	val b: Int = 10
	val c: Int = 100

	if (a == null) {
		println("a is null")
	} else {
		println("a is not null")
	}

	if (b + c == 110) {
		println("b plus c is 110")
	} else {
		println("b plus c is not 110")
	}

	// 엘비스 연산자
	// 엘비스 연산자는 `?:`로 표현함
	// `?:`의 왼쪽 객체가 non-null이면 그 객체의 값이 리턴되고,
	// null이라면 `?:`의 오른쪽 값을 리턴함
	val number: Int? = null
	val number2 = number ?: 10 // -> number가 null일 경우 10을 표출
	println()
	println("엘비스 연산자")
	println(number2)

	val num1: Int = 10
	val num2: Int = 20

	val max = if (num1 > num2) {
		num1
	} else if (num1 == num2) {
		num2
	} else {
		100
	}

}