package com.mashup.fourten.di

import com.mashup.fourten.data.remote.source.HabitRemoteDataSource
import com.mashup.fourten.data.remote.source.HabitRemoteDataSourceImpl
import com.mashup.fourten.data.repository.HabitRepository
import com.mashup.fourten.data.repository.HabitRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<HabitRepository> { HabitRepositoryImpl(get()) }

}