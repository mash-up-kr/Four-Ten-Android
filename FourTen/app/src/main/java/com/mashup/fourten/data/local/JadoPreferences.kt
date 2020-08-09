package com.mashup.fourten.data.local

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

object JadoPreferences {
    private const val PTTOKEN = "PT-TOKEN"
    private const val GOOGLETOKEN = "GOOGLE-TOKEN"
    lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
    }

    var ptToken: String
        get() = preferences.getString(PTTOKEN, "") ?: ""
        set(value) = preferences.let {
            it.edit().putString(PTTOKEN, value).apply()
        }

    var googleToken: String
        get() = preferences.getString(GOOGLETOKEN, "") ?: ""
        set(value) = preferences.let {
            it.edit().putString(GOOGLETOKEN, value).apply()
        }

}