package com.mashup.fourten.data.repository

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import io.reactivex.disposables.Disposable

interface SignRepositoryInterface {

    fun signIn(token: String, callback: BaseResponse<BaseResponseData<JsonElement>>): Disposable

    fun signUp(
        token: String,
        callback: BaseResponse<BaseResponseData<JsonObject>>,
        nickname: String
    ): Disposable

    fun signInCheck(callback: BaseResponse<BaseResponseData<JsonObject>>): Disposable
}