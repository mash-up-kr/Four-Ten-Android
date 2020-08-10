package com.mashup.fourten.data.local

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

object JadoPreferences {
    private const val PT_TOKEN = "PT-TOKEN"
    private const val GOOGLE_TOKEN = "GOOGLE-TOKEN"
    lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
    }

    var ptToken: String
        get() = preferences.getString(PT_TOKEN, "") ?: ""
        set(value) = preferences.let {
            it.edit().putString(PT_TOKEN, value).apply()
        }

    var googleToken: String
        get() = preferences.getString(GOOGLE_TOKEN, "") ?: ""
        set(value) = preferences.let {
            it.edit().putString(GOOGLE_TOKEN, value).apply()
        }

}