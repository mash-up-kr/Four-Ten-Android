package com.mashup.fourten.ui.splash

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.mashup.fourten.data.local.JadoPreferences.ptToken
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.repository.FruitRepositorylmpl
import com.mashup.fourten.data.repository.SignRepositoryImpl
import com.mashup.fourten.ui.base.BaseViewModel
import com.mashup.fourten.util.Event

enum class ResponseCode(val Code: Int) {
    FAIL(0),
    SUCCESS(1),
    SIGNUP(3),
    NICKNAME(4)
}

class SplashViewModel(val repo: FruitRepositorylmpl) : BaseViewModel() {

    val checkedSignInField = MutableLiveData<Event<Boolean>>()

    fun signInCheck() {
        repo.signInCheck(object : BaseResponse<BaseResponseData<JsonElement>> {
            override fun onSuccess(data: BaseResponseData<JsonElement>) {
                if (data.responseCode == ResponseCode.SUCCESS.Code) {
                    checkedSignInField.value = Event(true)
                } else {
                    checkedSignInField.value = Event(false)
                }
            }

            override fun onError(throwable: Throwable) {
            }

            override fun onLoading() {
            }

            override fun onLoaded() {
            }

        }).also { disposable.add(it) }
    }
}