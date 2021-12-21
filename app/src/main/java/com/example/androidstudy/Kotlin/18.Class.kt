package com.example.androidstudy.Kotlin

// 18. Class

// Object Oriented Programing (객체지향 프로그래밍)
// 객체란 뭘까?
//이름이 있는 모든 것

// 절차지향 프로그래밍 문제 해결 방법
// 코드를 위에서 부터 아래로 실행을 하면 문제가 해결된다!

// 객체지향 프로그래밍 문제 해결 방법
// 객체를 만들어서, 객체에게 일을 시켜서 문제를 해결한다
// - 선수, 심판, 경기장, 관중 → 축구 게임

// 객체를 만드는 방법
// 설명서가 있어야 한다.


fun main(args: Array<String>) {

	// 클래스(설명서)를 통해서 실체를 만드는 방법
	// -> 인스턴스화 -> 인스턴스(객체)
	Car("v8 engine", "big")

	val bigCar = Car("v8 engine", "big")

	// 우리가 만든 클래스(설명서는 자료형이 된다)
	val bigCar1: Car = Car("v8 engine", "big")
	val superCar: SuperCar = SuperCar("good engine", "big", "white")

	// 인스턴스가 가지고 있는 기능을 사용하는 방법
	val runableCar: RunableCar = RunableCar("simple engine", "short body")
	// RunableCar.ride() -> 불가능
	// 클래스(설명서)에 기능이 있는 것이 아닌 만들어진 결과에 기능이 있기 때문
	runableCar.ride()
	runableCar.navi("부산")
	runableCar.drive()

	// 인스턴스의 멤버 변수에 접근 하는 방법
	val runableCar2: RunableCar2 = RunableCar2("nice engine", "long body")
	runableCar2.ride()
	runableCar2.navi("서울")
	runableCar2.drive()

	println()
	val testClass: TestClass = TestClass()
	testClass.test(1)
	testClass.test(1, 2)
}

// 클래스(설명서) 만드는 방법 (1)
class Car(var engine: String, var body: String) {

}

// 클래스(설명서) 만드는 방법 (2)
class SuperCar {
	var engine: String
	var body: String
	var door: String

	constructor(engine: String, body: String, door: String) {
		this.engine = engine
		this.body = body
		this.door = door
	}
}

// 클래스(설명서) 만드는 방법 (3) -> 1번 방법의 확장
// class Car1 constructor(engine: String, body: String) { -> 이렇게도 가능
class Car1(engine: String, body: String) { // -> 이 클래스를 만들기 위해 반드시 필요한 것들을 적음
	var door: String = ""

	// 생성자
	// 반드시 필요한것 뿐만 아니라 추가적으로 있으면 좋은것들을 적어줌
	constructor(engine: String, body: String, door: String) : this(engine, body) {
		this.door = door
	}
}

// 클래스(설명서) 만드는 방법 (4) -> 2번 방법의 확장
class Car2 {
	var engine: String = ""
	var body: String = ""
	var door: String = ""

	constructor(engine: String, body: String) {
		this.engine = engine
		this.body = body
	}

	constructor(engine: String, body: String, door: String) {
		this.engine = engine
		this.body = body
		this.door = door
	}
}

class RunableCar(engine: String, body: String) {
	fun ride() {
		println("탑승 하였습니다.")
	}

	fun drive() {
		println("달립니다!")
	}

	fun navi(destination: String) {
		println("${destination}으로 목적지가 설정되었습니다.")
	}
}

class RunableCar2{
	var engine: String
	var body: String

	constructor(engine: String, body: String) {
		this.engine = engine
		this.body = body
	}

	// 객체, 즉 인스턴스화 될때 가장 먼저 호출됨
	init {
		// 초기 세팅 할때 유용하다!
		println("RunableCar2가 만들어 졌습니다.")
	}

	fun ride() {
		println("탑승 하였습니다.")
	}

	fun drive() {
		println("달립니다!")
	}

	fun navi(destination: String) {
		println("${destination}으로 목적지가 설정되었습니다.")
	}
}

// 오버로딩
// -> 이름이 같지만 파라미터가 다른 함수
// 클래스안에 있는 멤버변수는 동일한 이름을 사용할 수 없다
// 기본적으로 함수도 동일한 이름을 사용할 수 없지만
// 동일한 이름을 쓰는 함수가 받는 파라미터가 다르다면 이름이 동일한 함수를 사용할 수 있다
class TestClass() {
	fun test(a: Int) {
		println("up")
	}

	fun test(a: Int, b:Int) {
		println("down")
	}
}