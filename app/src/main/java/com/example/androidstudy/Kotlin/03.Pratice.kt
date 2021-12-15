package com.example.androidstudy.Kotlin

// 연산의 결과값을 변수에 넣어 줄 수 있다
var a = 1 + 2 + 3 + 4 + 5
var b = "1"
var c = b.toInt()
var d = b.toFloat()

var e = "John"
var f = "My name is $e Nice to meet you"


// Null
// - 존재 하지 않는다

// var abc1 = Int = null -> int형은 null을 받을 수 없다
var abc1 : Int? = null // -> 자료형 뒤에 '?'를 붙여주면 null을 받을 수 있다
var abc2 : Double? = null

var g = a + 3


fun main(args: Array<String>) {
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)

    println(abc1)

    println(g)
}