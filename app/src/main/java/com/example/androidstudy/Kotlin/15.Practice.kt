package com.example.androidstudy.Kotlin

fun main(args: Array<String>) {
	val a = mutableListOf<Int>(1, 2, 3)
	a.add(4)
	println(a)
	a.add(0, 100)
	println(a)
	a.set(0, 200)
	println(a)
	a.removeAt(1)
	println(a )

	println()
	val b = mutableSetOf<Int>(1,2,3,4)
	b.add(2)
	println(b)
	b.remove(2)
	println(b)
	// 값이 있으면 지워주고 없으면 그대로..
	// 없는 값이라도 에러가 나지 않음
	b.remove(100)
	println(b)

	println()
	val c = mutableMapOf<String, Int>("one" to 1)
	c.put("two", 2)
	println(c)
	c.replace("two", 3)
	// -> error가 나면 api레벨 24이상부터 사용할 수 있다는 내용임
	println(c)
	println(c.keys)
	println(c.values)
}