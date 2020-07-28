package com.mashup.fourten.data.remote.api

import com.mashup.fourten.data.model.request.SignInRequestData
import com.mashup.fourten.data.model.request.SignUpRequestData
import com.mashup.fourten.data.model.response.CommonResponse
import com.mashup.fourten.data.model.response.SignInResponseData
import com.mashup.fourten.data.model.response.SignUpResponseData
import io.reactivex.Single
import retrofit2.http.*


interface ApiService {
    @POST("/user/sing-in")
    fun requestSignIn(
        @Body params: SignInRequestData
    ): Single<CommonResponse<SignInResponseData>>

    @POST("/user/sing-up")
    fun requestSignUp(
        @Body params: SignUpRequestData
    ): Single<CommonResponse<SignUpResponseData>>

    @POST("/user/sing-in")
    fun requestAlreadyLoginCheck(
        @Header("PT-TOKEN") token: String,
        @Body params: SignInRequestData
    ): Single<CommonResponse<SignInResponseData>>
}


