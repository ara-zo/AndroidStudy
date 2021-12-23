package com.example.androidstudy.Kotlin
// 내가 만든 변수나 기능을 외부에 대한 접근을 막고 싶을때 private를 사용
fun main(args: Array<String>) {
	val night = Night(20, 4)
	val monster = Monster(15, 5)

	night.attack(monster)
	monster.attack(night)
}

class Night(private var hp: Int, private var power: Int) {
	fun attack(monster: Monster) {
		monster.defense(power)
	}

	fun defense(damage: Int) {
		hp -= damage
		if (hp > 0) {
			heal()
			println("기사의 현재 체력은 $hp 입니다.")
		} else {
			println("기사가 죽었습니다.")
		}
	}

	private fun heal() {
		hp += 3
	}
}

open class Monster(private var hp: Int, private var power: Int) {
	fun attack(night: Night) {
		night.defense(power)
	}

	fun defense(damage: Int) {
		hp -= damage
		if (hp > 0) {
			println("몬스터 현재 체력은 $hp 입니다.")
		} else {
			println("몬스터가 죽었습니다.")
		}
	}
}

// private로 만들어 외부에서 접근 불가능
// val로 변수를 선언해서 외부에서 변경도 불가능함
class Monster2(private val hp:Int, private val power: Int) {
	private fun attack() {

	}
}