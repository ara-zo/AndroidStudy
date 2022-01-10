package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_realm)

		// 초기화
		Realm.init(this@RealmActivity)



		// realm을 이런 방식으로 초기화 해달라는 config 생성
		val config: RealmConfiguration = RealmConfiguration.Builder()
											// UI Thread에서도 realm에 접근할 수 있도록 함
											.allowWritesOnUiThread(true)
											//Migration(데이터 베이스 동기화)가 필요하다면 Realm을 삭제
											.deleteRealmIfMigrationNeeded()
											.build()
		
		// allowWritesOnUiThread(true)를 안넣어주면 아래와 같은 에러가 남
		// io.realm.exceptions.RealmException: Running transactions on the UI thread has been disabled. It can be enabled by setting 'RealmConfiguration.Builder.allowWritesOnUiThread(true)'.
		// 원래 UI Thread에서 네트워크나 DB관련 기능들을 수행할 수 없지만,
		// 이 설정을 추가해주면 UI Thread에서도 realm에 접근할 수 있도록 만들어줌.

		Realm.setDefaultConfiguration(config)

		// realm을 얻어옴
		val realm = Realm.getDefaultInstance()

		button_save.setOnClickListener {
			realm.executeTransaction {
				// A테이블에서 데이터를 가져온다 -> 10
				// B테이블에서 데이터를 가져온다
				// C테이블에서 데이터를 가져온다
				// 조합을 한다
				// D테이블에 저장한다

				with(it.createObject(School::class.java)) {
					this.name = "어떤 대학교"
					this.location = "서울"
				}
			}
		}

		button_load.setOnClickListener {
			realm.executeTransaction {
				val data = it.where(School::class.java).findFirst()
				Log.d("dataa", "data : $data")
			}
		}

		button_delete.setOnClickListener {
			realm.executeTransaction {
				// 모든 데이터 삭제
				it.where(School::class.java).findAll().deleteAllFromRealm()
				// 첫번째 데이터 삭제
//				it.where(School::class.java).findFirst()?.deleteFromRealm()
			}
		}
	}
}