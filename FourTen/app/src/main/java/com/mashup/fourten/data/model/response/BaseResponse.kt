package com.mashup.fourten.data.model.response

interface BaseResponse<T> {

    fun onSuccess(data: T)

    fun onError(throwable: Throwable)

    fun onLoading()

    fun onLoaded()
}