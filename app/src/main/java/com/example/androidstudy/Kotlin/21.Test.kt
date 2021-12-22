package com.example.androidstudy.Kotlin

// 3) TV 클래스
//		- on/off 기능
// 		- 채널을 돌리는 기능
// 		- 초기 채널은 (S사, M사, K사 3개)
val channelList = listOf<String>("S사", "M사", "K사")
fun main(args: Array<String>) {
	val tv: Tv = Tv()
	tv.switch()
	tv.currentChannel()
	tv.up()
	tv.up()
	tv.up()
	tv.down()
	tv.down()
	tv.down()
	tv.switch()
}

class Tv() {
	var currentChannelNum: Int = 0
	var onOrOff: Boolean = false

	fun switch() {
		onOrOff = !onOrOff

		when (onOrOff) {
			true -> println("tv가 켜졌습니다.")
			else -> println("tv가 꺼졌습니다.")
		}
	}

	fun currentChannel() {
		println("현재 채널은 ${channelList[currentChannelNum]} 입니다")
	}

	fun up() {
		println("채널을 올립니다.")
		when (currentChannelNum) {
			2 -> currentChannelNum = 0
			else -> currentChannelNum += 1
		}
		println("현재 채널은 ${channelList[currentChannelNum]} 입니다")
	}

	fun down() {
		println("채널을 내립니다.")
		when (currentChannelNum) {
			0 -> currentChannelNum = 2
			else -> currentChannelNum -= 1
		}
		println("현재 채널은 ${channelList[currentChannelNum]} 입니다")
	}
}