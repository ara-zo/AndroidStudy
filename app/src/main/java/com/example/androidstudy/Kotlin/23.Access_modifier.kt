package com.example.androidstudy.Kotlin

// 23. 접근 제어자
// private 키워드 때문에 외부에서 접근 불가능


fun main(args: Array<String>) {
	val testAccess = TestAccess("아무개")
//	testAccess.test()
//	println(testAccess.name)
//	testAccess.name = "아무개 2"
//	println(testAccess.name)

//	val reward = Reward()
//	reward.rewardAmount = 2000
}

class Reward() {
	private var rewardAmount: Int = 1000
}

class TestAccess {
	private var name: String = "홍길동"

	constructor(name: String){
		this.name = name
	}

	fun changeName(newName: String) {
		this.name = newName
	}

	private fun test() {
		println("테스트")
	}
}