package com.mashup.fourten.data.model.request

import com.google.gson.annotations.SerializedName

data class SignUpRequestData(
    val snsType: String,
    val token: String,
    val nickname :String
)