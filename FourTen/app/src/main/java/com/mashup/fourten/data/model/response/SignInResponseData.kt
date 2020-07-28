package com.mashup.fourten.data.model.response

import com.google.gson.annotations.SerializedName

data class SignInResponseData(
    @SerializedName("responseCode")
    val responseCode: Int,
    @SerializedName("responseData")
    val responseData: SignInUserResponseData
)

data class SignInUserResponseData(
    @SerializedName("userSeq")
    val userSeq: Int,
    @SerializedName("snsType")
    val snsType: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("habits")
    val habits: List<String>
)

