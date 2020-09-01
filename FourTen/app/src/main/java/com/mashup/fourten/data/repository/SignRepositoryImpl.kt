package com.mashup.fourten.data.repository

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.mashup.fourten.data.model.request.SignInRequestData
import com.mashup.fourten.data.model.request.SignUpRequestData
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.remote.api.SignApiService
import com.mashup.fourten.util.ext.observeSingle
import io.reactivex.disposables.Disposable

class SignRepositoryImpl(private val signApi: SignApiService) : SignRepository {

    override fun signIn(
        token: String,
        callback: BaseResponse<BaseResponseData<JsonElement>>
    ): Disposable {
        return signApi.requestSignIn(SignInRequestData(SnsType.GOOGLE.snsType, token))
            .observeSingle(callback)
    }

    override fun signUp(
        token: String,
        callback: BaseResponse<BaseResponseData<JsonObject>>,
        nickname: String
    ): Disposable {
        return signApi.requestSignUp(SignUpRequestData(SnsType.GOOGLE.snsType, token, nickname))
            .observeSingle(callback)
    }

}