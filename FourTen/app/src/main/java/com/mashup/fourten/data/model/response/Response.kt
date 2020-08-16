package com.mashup.fourten.data.model.response

data class Response<T>(
    val responseCode: Int,
    val responseData: T
)
