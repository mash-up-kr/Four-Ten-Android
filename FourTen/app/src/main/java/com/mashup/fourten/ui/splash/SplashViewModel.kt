package com.mashup.fourten.ui.splash

import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.CommonResponse
import com.mashup.fourten.data.model.response.SignInResponseData
import com.mashup.fourten.data.remote.api.ApiService
import com.mashup.fourten.data.repository.SignRepositoryImpl
import com.mashup.fourten.ui.base.BaseViewModel
import com.mashup.fourten.ui.login.LoginActivity
import com.mashup.fourten.ui.main.MainActivity
import com.mashup.fourten.util.Event
import com.mashup.fourten.util.ext.start
import org.koin.java.KoinJavaComponent.inject

class SplashViewModel(val repo: SignRepositoryImpl) : BaseViewModel() {

    val checkedSignInField = MutableLiveData<Event<Boolean>>()

    fun signInCheck(serverToken: String) {
        repo.signInCheck(serverToken, object : BaseResponse<SignInResponseData> {
            override fun onSuccess(data: CommonResponse<SignInResponseData>) {
                if (data.responseCode == 1) {
                    checkedSignInField.postValue(Event(true))
                }
            }

            override fun onError(throwable: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onLoading() {
                TODO("Not yet implemented")
            }

            override fun onLoaded() {
                TODO("Not yet implemented")
            }

        })
    }
}