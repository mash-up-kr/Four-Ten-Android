package com.mashup.fourten.data.model.response

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class SignUpUserResponseData(
    val userSeq: Int,
    val snsType: String,
    val token: String,
    val nickname: String,
    val habits: List<String>
)