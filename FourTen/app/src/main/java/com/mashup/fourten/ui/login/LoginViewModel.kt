package com.mashup.fourten.ui.login

import android.util.Log
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mashup.fourten.R
import com.mashup.fourten.data.local.JadoPreferences
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.SignInResponseData
import com.mashup.fourten.data.model.response.SignInUserResponseData
import com.mashup.fourten.data.model.response.SignUpUserResponseData
import com.mashup.fourten.data.repository.SignRepositoryImpl
import com.mashup.fourten.ui.base.BaseViewModel
import com.mashup.fourten.util.Event

class LoginViewModel(val repo: SignRepositoryImpl) : BaseViewModel() {

    val idCheckedField = MutableLiveData<Event<Boolean>>()

    fun idCheck() {
        repo.signIn(JadoPreferences.googleToken, object : BaseResponse<SignInResponseData> {
            override fun onSuccess(data: SignInResponseData) {
                if (data.responseCode == 1) {

                    val gson = GsonBuilder().setPrettyPrinting().create()
                    JadoPreferences.ptToken =
                        gson.fromJson(
                            data.responseData.toString(),
                            SignInUserResponseData::class.java
                        ).token
                    idCheckedField.postValue(Event(true))
                } else if (data.responseCode == 3) {
                    idCheckedField.postValue(Event(false))
                }
            }

            override fun onError(throwable: Throwable) {
                Log.e("error", throwable.toString())
            }

            override fun onLoading() {
            }

            override fun onLoaded() {
            }

        })
    }
}