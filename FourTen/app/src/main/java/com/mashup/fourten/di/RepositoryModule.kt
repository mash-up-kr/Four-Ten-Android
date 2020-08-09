package com.mashup.fourten.di


import com.mashup.fourten.data.repository.FruitRepositorylmpl
import com.mashup.fourten.data.repository.SignRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module(override = true) {

    single {
        SignRepositoryImpl(get())
    }

    single {
        FruitRepositorylmpl(get())
    }
}