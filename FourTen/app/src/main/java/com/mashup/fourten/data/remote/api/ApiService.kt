package com.mashup.fourten.data.remote.api

import com.google.gson.JsonObject
import com.mashup.fourten.data.model.request.SignInRequestData
import com.mashup.fourten.data.model.request.SignUpRequestData
import com.mashup.fourten.data.model.response.SignInCheckResponseData
import com.mashup.fourten.data.model.response.SignInResponseData
import com.mashup.fourten.data.model.response.SignUpResponseData
import io.reactivex.Single
import retrofit2.http.*


interface ApiService {
    @POST("user/sign-in")
    fun requestSignIn(
        @Body params: SignInRequestData
    ): Single<SignInResponseData>

    @POST("user/sign-up")
    fun requestSignUp(
        @Body params: SignUpRequestData
    ): Single<SignUpResponseData>

    @POST("user/sign-in")
    fun requestSignInCheck(
        @Header("PT-TOKEN") token: String,
        @Body params: SignInRequestData
    ): Single<SignInCheckResponseData>
}


