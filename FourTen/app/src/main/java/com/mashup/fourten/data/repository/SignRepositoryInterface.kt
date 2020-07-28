package com.mashup.fourten.data.repository

import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.SignInResponseData
import com.mashup.fourten.data.model.response.SignUpResponseData
import io.reactivex.disposables.Disposable

interface SignRepositoryInterface {

    fun signIn(token: String, callback: BaseResponse<SignInResponseData>): Disposable

    fun signUp(
        token: String,
        callback: BaseResponse<SignUpResponseData>,
        nickname: String
    ): Disposable

    fun signInCheck(token: String, callback: BaseResponse<SignInResponseData>): Disposable
}