package com.example.androidstudy

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by arazo on 2022-01-11.
 */
class MasterApplication : Application() {

	lateinit var service: RetrofitService

	override fun onCreate() {
		super.onCreate()

		// 스테토 초기화
		Stetho.initializeWithDefaults(this@MasterApplication)
		createRetrofit()
		//chrome://inspect/#devices 에 접속
	}

	fun createRetrofit() {
		val header = Interceptor {
			val original = it.request()

			if (checkIsLogin()) {
				getUserToken()?.let { token ->
					val request = original.newBuilder()
						.header("Authorization", "token $token")
						.build()
					it.proceed(request)
				}
			} else {
				it.proceed(original)
			}
		}

		val client = OkHttpClient.Builder()
			.addInterceptor(header)
			.addNetworkInterceptor(StethoInterceptor())
			.build()

		val retrofit = Retrofit.Builder()
			.baseUrl("http://mellowcode.org/")
			.addConverterFactory(GsonConverterFactory.create())
			.client(client)
			.build()

		service = retrofit.create(RetrofitService::class.java)
	}

	fun checkIsLogin(): Boolean {
		val sharedPreference = getSharedPreferences("login_sp", Context.MODE_PRIVATE)

		val token = sharedPreference.getString("login_sp", "null")

		return token != "null"
	}

	fun getUserToken(): String? {
		val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
		return sp.getString("login_sp", null)
	}
}