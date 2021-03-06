package com.mashup.fourten.data.remote.api

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.mashup.fourten.data.model.request.SignInRequestData
import com.mashup.fourten.data.model.request.SignUpRequestData
import com.mashup.fourten.data.model.response.BaseResponseData
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface SignApiService {
    @POST("user/sign-in")
    fun requestSignIn(
        @Body params: SignInRequestData
    ): Single<BaseResponseData<JsonElement>>

    @POST("user/sign-up")
    fun requestSignUp(
        @Body params: SignUpRequestData
    ): Single<BaseResponseData<JsonElement>>

}


