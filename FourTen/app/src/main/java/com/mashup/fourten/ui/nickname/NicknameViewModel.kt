package com.mashup.fourten.ui.nickname

import androidx.lifecycle.LiveData
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

    private val _nicknameField = MutableLiveData<String>()

    private val _toastField = MutableLiveData<Event<Int>>()

    private val _loginField = MutableLiveData<Event<Int>>()

    val nicknameField: LiveData<String> = _nicknameField

    val toastField: LiveData<Event<Int>> = _toastField

    val loginField: LiveData<Event<Int>> = _loginField

    fun signUp() {
        if (nicknameField.value.isNullOrEmpty()) {
            _toastField.value = Event<Int>(R.string.put_nickname)
        } else {
            repo.signUp(
                JadoPreferences.googleToken,
                object : BaseResponse<BaseResponseData<JsonObject>> {
                    override fun onSuccess(data: BaseResponseData<JsonObject>) {
                        if (data.responseCode == ResponseCode.SUCCESS.Code) {
                            _toastField.value = Event<Int>(R.string.success_sign_up)
                            _loginField.value = Event(0)
                        } else if (data.responseCode == ResponseCode.NICKNAME.Code) {
                            _toastField.value = Event<Int>(R.string.overlap_nickname)
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