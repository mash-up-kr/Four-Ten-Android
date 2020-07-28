package com.mashup.fourten.data.repository

import com.mashup.fourten.data.model.request.SignInRequestData
import com.mashup.fourten.data.model.request.SignUpRequestData
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.SignInResponseData
import com.mashup.fourten.data.model.response.SignUpResponseData
import com.mashup.fourten.data.remote.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SignRepositoryImpl(private val api: ApiService) : SignRepositoryInterface {
    override fun signIn(token: String, callback: BaseResponse<SignInResponseData>): Disposable {
        return api.requestSignIn(SignInRequestData("google", token))
            .doOnSubscribe { callback.onLoading() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback.onLoaded()
                callback.onSuccess(it)
            }, {
                callback.onError(it)
            })
    }

    override fun signUp(
        token: String,
        callback: BaseResponse<SignUpResponseData>,
        nickname: String
    ): Disposable {
        return api.requestSignUp(SignUpRequestData("google", token, nickname))
            .doOnSubscribe { callback.onLoading() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback.onLoaded()
                callback.onSuccess(it)
            }, {
                callback.onError(it)
            })
    }

    override fun signInCheck(
        token: String,
        callback: BaseResponse<SignInResponseData>
    ): Disposable {
        return api.requestAlreadyLoginCheck(token, SignInRequestData("google", ""))
            .doOnSubscribe { callback.onLoading() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback.onLoaded()
                callback.onSuccess(it)
            }, {
                callback.onError(it)
            })
    }

}