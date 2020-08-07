package com.mashup.fourten.data.model.response

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class SignInCheckResponseData(
    @SerializedName("responseCode")
    val responseCode: Int,
    @SerializedName("responseData")
    val responseData: JsonObject
)

