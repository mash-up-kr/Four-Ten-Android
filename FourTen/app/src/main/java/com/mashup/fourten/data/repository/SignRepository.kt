package com.mashup.fourten.data.repository

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import io.reactivex.disposables.Disposable

interface SignRepository {

    fun signIn(token: String, callback: BaseResponse<BaseResponseData<JsonObject>>): Disposable

    fun signUp(
        token: String,
        callback: BaseResponse<BaseResponseData<JsonObject>>,
        nickname: String
    ): Disposable

}