package com.mashup.fourten.data.model.request

import com.google.gson.annotations.SerializedName

data class SignInRequestData(
    @SerializedName("snsType")
    val snsType: String,
    @SerializedName("token")
    val token: String
)