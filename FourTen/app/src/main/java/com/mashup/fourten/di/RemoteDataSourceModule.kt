package com.mashup.fourten.di

import com.mashup.fourten.data.remote.source.HabitRemoteDataSource
import com.mashup.fourten.data.remote.source.HabitRemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<HabitRemoteDataSource> {HabitRemoteDataSourceImpl(get())}

}
