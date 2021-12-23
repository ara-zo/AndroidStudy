package com.example.androidstudy.Kotlin

// 27. Interface
// - 인터페이스는 약속! -> 니가 이것을 구현하면 너도 이 타입이다!
// 인터페이스를 구현하는 클래스는 인터페이스가 가지고 있는 기능을 반드시 구현해줘야함
// 정확한 기능을 설명해줘야 함

// - 생성자가 없다 -> 인스턴스화 시킬 수 없다! -> 설명서가 아니다!
// - 지침서 -> 니가 이것을 구현하고 싶다면 반드시 아래 기능을 구현해라!

// 상속과 다른점
// - 상속은 조상을 찾아가는 느낌
// - 인터페이스는 종의 특징

fun main(args: Array<String>) {
	val student_: Student_ = Student_()
	student_.eat()
	student_.sleep()

}

interface Person_ {
	fun eat()
	fun sleep()
}

class Student_ : Person_ {
	override fun eat() {

	}

	override fun sleep() {
	}
}

class SoccerPlayer : Person_ {
	override fun eat() {

	}

	override fun sleep() {
	}
}


// 자식클래스들이 공통으로 가지고 있는 기능들을 부모클래스에 올려두면 편하다
// 자식클래스가 부모클래스의 기능을 쓰긴 쓰는데 조금 다를때
open class Person() {
	open fun eat() {

	}

	fun sleep() {

	}
}

class Student() : Person() {
	override fun eat() {
		super.eat()
	}
}

class Teacher() : Person() {

}