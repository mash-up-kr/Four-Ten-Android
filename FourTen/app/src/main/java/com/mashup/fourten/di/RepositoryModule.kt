package com.mashup.fourten.di

import com.mashup.fourten.data.repository.SignRepositoryImpl
import com.mashup.fourten.data.repository.SignRepositoryInterface
import org.koin.dsl.module


val repositoryModule = module(override = true) {
    single {
        SignRepositoryImpl(get())
    }
}