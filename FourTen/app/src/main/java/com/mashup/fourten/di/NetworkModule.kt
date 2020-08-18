package com.mashup.fourten.di

import com.google.gson.GsonBuilder
import com.mashup.fourten.BuildConfig
import com.mashup.fourten.data.local.JadoPreferences
import com.mashup.fourten.data.remote.api.FruitApiService
import com.mashup.fourten.data.remote.api.SignApiService
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "http://61.97.186.168:8080/"
private const val TIMEOUT: Long = 10L

val networkModule = module(override = true) {

    single(named("headerInterceptor")) {
        Interceptor {
            val original = it.request()
            val unbuildedRequest = original.newBuilder()
                .method(original.method(), original.body())
            lateinit var request: Request
            if (!JadoPreferences.ptToken.isNullOrEmpty()) {
                request = unbuildedRequest.addHeader("PT-TOKEN", JadoPreferences.ptToken)
                    .build()
            } else {
                request = unbuildedRequest.build()
            }
            it.proceed(request)
        }
    }

    single(named("httpLoggingInterceptor")) {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    single {
        GsonBuilder().setLenient().create()
    }

    single(named("ptTokenHeader")) {
        OkHttpClient.Builder()
            .addInterceptor(get(named("headerInterceptor")))
            //.addInterceptor(get(named("httpLoggingInterceptor")))
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    single(named("beforeLoginRetrofit")) {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create(get()))
            .baseUrl(BASE_URL)
            .build()
    }

    single(named("afterLoginRetrofit")) {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get(named("ptTokenHeader")))
            .baseUrl(BASE_URL)
            .build()
    }

    single(named("afterLoginApi")) {
        get<Retrofit>(named("afterLoginRetrofit")).create(FruitApiService::class.java)
    }

    single(named("beforeLoginApi")) {
        get<Retrofit>(named("beforeLoginRetrofit")).create(SignApiService::class.java)
    }

}