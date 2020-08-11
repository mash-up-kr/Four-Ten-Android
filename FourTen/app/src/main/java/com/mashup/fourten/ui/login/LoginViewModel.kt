package com.mashup.fourten.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.mashup.fourten.data.local.JadoPreferences
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.model.response.SignInUserResponseData
import com.mashup.fourten.data.repository.SignRepositoryImpl
import com.mashup.fourten.ui.base.BaseViewModel
import com.mashup.fourten.ui.splash.ResponseCode
import com.mashup.fourten.util.Event

class LoginViewModel(val repo: SignRepositoryImpl) : BaseViewModel() {

    val idCheckedField = MutableLiveData<Event<Boolean>>()

    fun idCheck() {
        repo.signIn(
            JadoPreferences.googleToken,
            object : BaseResponse<BaseResponseData<JsonObject>> {
                override fun onSuccess(data: BaseResponseData<JsonObject>) {
                    if (data.responseCode == ResponseCode.SUCCESS.Code) {
                        val gson = GsonBuilder().setPrettyPrinting().create()
                        JadoPreferences.ptToken =
                            gson.fromJson(
                                data.responseData.toString(),
                                SignInUserResponseData::class.java
                            ).token
                        idCheckedField.postValue(Event(true))
                    } else if (data.responseCode == ResponseCode.SIGNUP.Code) {
                        idCheckedField.postValue(Event(false))
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