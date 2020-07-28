package com.mashup.fourten.data.model.request

import com.google.gson.annotations.SerializedName

data class SignUpRequestData(
    @SerializedName("snsType")
    val snsType: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("nickname")
    val nickname :String
)