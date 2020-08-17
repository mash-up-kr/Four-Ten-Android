package com.mashup.fourten.di

<<<<<<< HEAD

import com.mashup.fourten.data.repository.FruitRepositorylmpl
import com.mashup.fourten.data.repository.SignRepositoryImpl
import com.mashup.fourten.data.repository.HabitRepository
import com.mashup.fourten.data.repository.HabitRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module


val repositoryModule = module(override = true) {

    single {
        SignRepositoryImpl(get(named("beforeLoginApi")))
    }

    single {
        FruitRepositorylmpl(get(named("afterLoginApi")))
    }

    single<HabitRepository> { HabitRepositoryImpl(get()) }

}