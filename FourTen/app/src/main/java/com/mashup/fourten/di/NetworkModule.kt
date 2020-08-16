package com.mashup.fourten.di

import com.google.gson.GsonBuilder
import com.mashup.fourten.BuildConfig
import com.mashup.fourten.data.remote.api.Api
import com.mashup.fourten.data.remote.api.ApiService
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = Api.BASE_URL
private const val TIMEOUT: Long = 10L

private const val TEMP_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTk1NzEzMjQ0LCJleHAiOjE1OTgzMDUyNDR9.kdYgdORtjR5Il7EJ4IQWWM1mRxLXKFaDRUOwWT4U2mE"

val networkModule = module(override = true) {

    single(named("headerInterceptor")) {
        Interceptor {
            val original = it.request()
            val request = original.newBuilder()
                .removeHeader("PT-TOKEN")
                .addHeader("PT-TOKEN", TEMP_TOKEN)
                .method(original.method(), original.body())
                .build()
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

    single {
        OkHttpClient.Builder()
            .addInterceptor(get(named("headerInterceptor")))
            .addInterceptor(get(named("httpLoggingInterceptor")))
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    single(named("urlApi")) {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .baseUrl(BASE_URL)
            .build()
    }

    single {
        get<Retrofit>(named("urlApi")).create(ApiService::class.java)
    }
}

