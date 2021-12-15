package com.example.androidstudy.Kotlin

fun plus(first: Int, second: Int): Int {
    println(first)
    println(second)
    val result: Int = first + second;
    println(result)
    return  result
}

// - 디폴트 값을 갖는 함수 만들기
fun plusFive(first: Int = 0, second: Int = 5 ): Int {
    val result: Int = first + second
    return result
}


fun main(args: Array<String>) {
    // 함수를 호출 하는 방법
    val result = plus(5, 10)
    println("result $result")

    // 인수를 명시적으로 전달하는 방법
    val result2 = plus(first = 20, second = 30)
    println("result2 $result2")

    // 디폴트 값을 갖는 함수 호출하기
    println()
    val result4 = plusFive(10, 20)
    println(result4)
}