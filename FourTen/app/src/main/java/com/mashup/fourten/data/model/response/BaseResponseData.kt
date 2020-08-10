package com.mashup.fourten.data.model.response

import com.google.gson.annotations.SerializedName

data class BaseResponseData<T>(
    val responseCode: Int,
    val responseData: T
)