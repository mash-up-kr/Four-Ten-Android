package com.mashup.fourten.data.model.request

import com.mashup.fourten.data.repository.SignRepositoryImpl

data class SignUpRequestData(
    val snsType: String,
    val token: String,
    val nickname:String
)