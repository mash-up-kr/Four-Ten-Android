package com.mashup.fourten.data.remote.api

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.mashup.fourten.data.model.request.SignInRequestData
import com.mashup.fourten.data.model.request.SignUpRequestData
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.model.response.HabitListResponseData
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiService {
    @POST("user/sign-in")
    fun requestSignIn(
        @Body params: SignInRequestData
    ): Single<BaseResponseData<JsonElement>>

    @POST("user/sign-up")
    fun requestSignUp(
        @Body params: SignUpRequestData
    ): Single<BaseResponseData<JsonObject>>

    @POST("user/sign-in")
    fun requestSignInCheck(
        @Header("PT-TOKEN") token: String,
        @Body params: SignInRequestData
    ): Single<BaseResponseData<JsonObject>>

    @GET("habit/list")
    fun requestHabitList(
        @Header("PT-TOKEN") token: String
    ): Single<BaseResponseData<List<HabitListResponseData>>>
}


