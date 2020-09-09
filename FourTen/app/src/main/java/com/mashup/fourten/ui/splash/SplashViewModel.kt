package com.mashup.fourten.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.remote.source.FruitRemoteDataSource
import com.mashup.fourten.ui.base.BaseViewModel
import com.mashup.fourten.util.Event

enum class ResponseCode(val Code: Int) {
    FAIL(0),
    SUCCESS(1),
    SIGNUP(3),
    NICKNAME(4)
}

class SplashViewModel(private val fruitDataSource: FruitRemoteDataSource) : BaseViewModel() {

    private val _checkedSignInField = MutableLiveData<Event<Boolean>>()
    val checkedSignInField: LiveData<Event<Boolean>> = _checkedSignInField

    fun signInCheck() {
        fruitDataSource.signInCheck(object : BaseResponse<BaseResponseData<JsonElement>> {
            override fun onSuccess(data: BaseResponseData<JsonElement>) {
                if (data.responseCode == ResponseCode.SUCCESS.Code) {
                    _checkedSignInField.value = Event(true)
                } else {
                    _checkedSignInField.value = Event(false)
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