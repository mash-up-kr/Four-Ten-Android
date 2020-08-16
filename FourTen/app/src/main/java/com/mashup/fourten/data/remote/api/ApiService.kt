package com.mashup.fourten.data.remote.api

import com.mashup.fourten.data.model.HabitItem
import com.mashup.fourten.data.model.response.Response
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    @POST("/habit")
    fun addHabit(): Single<Response<HabitItem>>

    @GET("/habit/list")
    fun getHabitList(): Single<Response<List<HabitItem>>>
}