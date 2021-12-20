package com.example.androidstudy.Kotlin

// 14. Collection
// 가장 많이 사용되는 3가지 collection
// → list, set, map


fun main(args: Array<String>) {

	// Immutable Collection (변경 불가능)
	// List
	val numberList = listOf<Int>(1, 2, 3, 3, 3)
	println(numberList)
	println(numberList.get(0))
	println(numberList[0])

	println()
	// Set
	// 중복값을 허용 하지 않음
	// 순서가 없다!!
	val numberSet = setOf<Int>(1, 2, 3, 3, 3)
	println(numberSet)
	numberSet.forEach {
		println(it)
	}

	println()
	// Map
	// Key, value 방식으로 관리함
	val numberMap = mapOf<String, Int>("one" to 1, "two" to 2)
	println(numberMap.get("one"))
	println(numberMap["one"])

	// Mutable Collection (변경 가능)
	val mNumberList = mutableListOf<Int>(1, 2, 3)
	mNumberList.add(3, 4)
	println()
	println(mNumberList)

	val mNumberSet = mutableSetOf<Int>(1, 2, 3, 4, 4, 4)
	mNumberSet.add(10)
	println()
	println(mNumberSet)

	val mNumberMap = mutableMapOf<String, Int>("one" to 1)
	mNumberMap.put("two", 2)
	println()
	println(mNumberMap)
}