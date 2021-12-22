package com.example.androidstudy.Kotlin

// 2) 은행 계좌 만들기
//		- 계좌 생성 기능 (이름, 생년 월일)
//		- 잔고를 확인 하는 기능
//		- 출금 기능
//		- 예금 기능
var accountList = mutableListOf<Account>()
fun main(args: Array<String>) {
	accountList.clear()

	var bank: Bank = Bank()
	bank.createAccount("홍길동", "010101")
	bank.searchAccount("홍길동")
	bank.searchAccount("ㅇㅇㅇ")

	bank.withdraw("홍길동", 8)
	bank.deposit("홍길동", 10)

}

class Bank() {
	fun createAccount(name: String, birth: String) {
		accountList.add(Account(name, birth))
		println("계좌가 생성되었습니다.")
		println("이름 : $name, 생년월일 : $birth, 잔고 : 0")
	}

	fun searchAccount(name: String) {
		val account = accountList.find { it.name == name }
		if (account != null) {
			println("계좌 조회")
			println("이름 : ${account.name}, 생년월일 : ${account.birth}, 잔고 : ${account.balance}")
		} else {
			println("계좌가 없습니다.")
		}
	}

	fun deposit(name: String, money: Int) {
		val account = accountList.find { account -> account.name == name }
		val index = accountList.indexOf(account)

		if (account != null) {
			accountList[index] = Account(account.name, account.birth, (account.balance + money))
			println("입금했습니다.")
			println("이름 : ${account.name}, 생년월일 : ${account.birth}, 잔고 : ${account.balance + money}")
		} else {
			println("계좌가 없습니다.")
		}
	}

	fun withdraw(name: String, money: Int) {
		val account = accountList.find { account -> account.name == name }
		val index = accountList.indexOf(account)

		if (account != null) {
			when(money < account.balance) {
				true -> {
					accountList[index] = Account(account.name, account.birth, (account.balance - money))
					println("출금했습니다.")
					println("이름 : ${account.name}, 생년월일 : ${account.birth}, 잔고 : ${account.balance - money}")
				}
				else -> {
					println("잔고가 없습니다.")
					println("이름 : ${account.name}, 생년월일 : ${account.birth}, 잔고 : ${account.balance}")
				}
			}
		} else {
			println("계좌가 없습니다.")
		}
	}

}

class Account(var name: String, var birth: String, var balance: Int = 0) {

}