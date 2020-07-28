package com.mashup.fourten.data.model.response

interface BaseResponse<T> {

    fun onSuccess(data: CommonResponse<T>)

    fun onError(throwable: Throwable)

    fun onLoading()

    fun onLoaded()
}