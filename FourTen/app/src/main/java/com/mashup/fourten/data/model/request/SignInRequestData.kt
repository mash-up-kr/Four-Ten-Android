package com.mashup.fourten.data.model.request

import com.google.gson.annotations.SerializedName

data class SignInRequestData(
    val snsType: String,
    val token: String
)