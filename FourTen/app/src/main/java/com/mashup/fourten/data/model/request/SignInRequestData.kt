package com.mashup.fourten.data.model.request

import com.mashup.fourten.data.repository.SignRepositoryImpl

data class SignInRequestData(
    val snsType: SignRepositoryImpl.SnsType,
    val token: String
)