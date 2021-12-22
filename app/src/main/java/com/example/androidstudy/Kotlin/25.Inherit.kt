package com.example.androidstudy.Kotlin


// 두번 이상이 넘어가면 리펙토링

// 25. 상속
//

fun main(args: Array<String>) {
	val superCar100: SuperCar100 = SuperCar100()
	println(superCar100.drive())
//	superCar100.stop()
//
//	val bus100: Bus100 = Bus100()
//	bus100.drive()
//	bus100.stop()
}

// 부모 : Car100
// 자식 : SuperCar100, Bus100
open class Car100() {
	open fun drive(): String {
		return "달린다"
	}

	fun stop() {

	}
}

class SuperCar100(): Car100() {
	override fun drive(): String {
		// super = 부모
		val run = super.drive()
		return "빨리 $run"
	}
}

class Bus100(): Car100() {

}
