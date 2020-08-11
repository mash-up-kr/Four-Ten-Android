package com.mashup.fourten.util.ext

import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

fun <T1 : BaseResponseData<T2>, T2> Single<T1>.observeSingle(callback: BaseResponse<T1>): Disposable {
    return this.doOnSubscribe { callback.onLoading() }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            callback.onLoaded()
            callback.onSuccess(it)
        }, {
            callback.onError(it)
        })
}