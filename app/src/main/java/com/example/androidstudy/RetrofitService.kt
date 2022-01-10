package com.example.androidstudy

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by arazo on 2022-01-10.
 */
interface RetrofitService {

	@GET("json/students/")
	fun getStudentsList(): Call<ArrayList<PersonFromServer>>

	@POST("json/students/")
	fun createStudent(
		@Body params: HashMap<String, Any>
	): Call<PersonFromServer>

	@POST("json/students/")
	fun createStudentEasy(
		@Body person: PersonFromServer
	): Call<PersonFromServer>
}