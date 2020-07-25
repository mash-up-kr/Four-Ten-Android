package com.mashup.fourten

import android.app.Application
import com.mashup.fourten.di.*
import com.mashup.fourten.util.NotificationBuilder
import com.mashup.fourten.util.ext.setupKoin

class JadoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin(
            this,
            viewModelModule,
            networkModule,
            repositoryModule,
            remoteDataSourceModule,
            localDataSourceModule
        )
        NotificationBuilder.createNotificationChannel(this)
    }

}