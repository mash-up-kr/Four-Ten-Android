package com.mashup.fourten.ui.nickname

import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import com.mashup.fourten.R
import com.mashup.fourten.data.local.JadoPreferences
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.repository.SignRepositoryImpl
import com.mashup.fourten.ui.base.BaseViewModel
import com.mashup.fourten.ui.splash.ResponseCode
import com.mashup.fourten.util.Event

class NicknameViewModel(val repo: SignRepositoryImpl) : BaseViewModel() {

    val nicknameField = MutableLiveData<String>()

    val toastField = MutableLiveData<Event<Int>>()

    val loginField = MutableLiveData<Event<Int>>()

    fun signUp() {
        if (nicknameField.value.isNullOrEmpty()) {
            toastField.postValue(Event<Int>(R.string.put_nickname))
        } else {
            repo.signUp(
                JadoPreferences.googleToken,
                object : BaseResponse<BaseResponseData<JsonObject>> {
                    override fun onSuccess(data: BaseResponseData<JsonObject>) {
                        if (data.responseCode == ResponseCode.SUCCESS.Code) {
                            toastField.postValue(Event<Int>(R.string.success_sign_up))
                            loginField.postValue(Event(0))
                        } else if (data.responseCode == ResponseCode.NICKNAME.Code) {
                            toastField.postValue(Event<Int>(R.string.overlap_nickname))
                        }
                    }

                    override fun onError(throwable: Throwable) {
                    }

                    override fun onLoading() {
                    }

                    override fun onLoaded() {
                    }

                },
                nicknameField.value!!
            ).also { disposable.add(it) }
        }
    }
}