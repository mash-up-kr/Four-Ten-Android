package com.mashup.fourten.ui.splash

import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import com.mashup.fourten.data.local.JadoPreferences.ptToken
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.repository.SignRepositoryImpl
import com.mashup.fourten.ui.base.BaseViewModel
import com.mashup.fourten.util.Event


class SplashViewModel(val repo: SignRepositoryImpl) : BaseViewModel() {

    val checkedSignInField = MutableLiveData<Event<Boolean>>()

    fun signInCheck() {
        repo.signInCheck(object : BaseResponse<BaseResponseData<JsonObject>> {
            override fun onSuccess(data: BaseResponseData<JsonObject>) {
                if (data.responseCode == 1) {
                    checkedSignInField.postValue(Event(true))
                } else {
                    checkedSignInField.postValue(Event(false))
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