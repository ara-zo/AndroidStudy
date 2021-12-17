package com.example.androidstudy.Kotlin

fun plusThree(first: Int, second:Int, third:Int): Int {
	return first + second + third
}

fun minusThree(first: Int, second: Int, third: Int) = first - second - third

fun mutiplyThree(first: Int = 1, second: Int = 1, third: Int = 1): Int {
	return first * second * third
}

// 내부함수
// - 함수 안에 함수가 있다!
fun showMyPlus(first: Int, second: Int): Int {
	println(first)
	println(second)

	fun plus(first: Int, second: Int): Int {
		return first + second
	}

	return  plus(first, second)
}

fun main(args: Array<String>) {
	val result = plusThree(1, 2, 3)
	println(result)
	val result2 = minusThree(10, 1, 2)
	println(result2)
	val result3 = mutiplyThree(2, 2, 2)
	println(result3)
	val result4 = mutiplyThree()
	println(result4)

	println()
	val result5 = showMyPlus(4,5)
	println(result5)

}