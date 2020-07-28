package com.mashup.fourten.data.model.response

import com.google.gson.annotations.SerializedName

data class CommonResponse<T>(
    @SerializedName("responseCode")
    val responseCode:Int,
    @SerializedName("responseData")
    val responseData:T
)
