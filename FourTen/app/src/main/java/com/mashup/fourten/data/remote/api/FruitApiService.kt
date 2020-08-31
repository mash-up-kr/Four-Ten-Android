package com.mashup.fourten.data.remote.api

import com.google.gson.JsonElement
import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.data.model.request.SignInRequestData
import com.mashup.fourten.data.model.response.BaseResponseData
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface FruitApiService {
    @POST("user/sign-in")
    fun requestSignInCheck(
        @Body params: SignInRequestData
    ): Single<BaseResponseData<JsonElement>>

    @GET("habit/list")
    fun requestHabitList(): Single<BaseResponseData<List<Habit>>>

}


