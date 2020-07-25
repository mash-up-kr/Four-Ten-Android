package com.mashup.fourten.util.ext

import android.util.Log
import com.mashup.fourten.BuildConfig

fun e(TAG: String, message: String) {
    if (BuildConfig.DEBUG) {
        Log.e(TAG, message)
    }
}

fun e(TAG: String, message: String, e: Exception?) {
    if (BuildConfig.DEBUG) {
        Log.e(TAG, message, e)
    }
}

fun e(TAG: String, e: Exception?) {
    if (BuildConfig.DEBUG) {
        Log.e(TAG, "error : ", e)
    }
}

fun e(TAG: String, message: String, e: Throwable?) {
    if (BuildConfig.DEBUG) {
        Log.e(TAG, message, e)
    }
}


fun d(TAG: String, message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(TAG, message)
    }
}

fun d(TAG: String, message: String, e: Exception?) {
    if (BuildConfig.DEBUG) {
        Log.d(TAG, message, e)
    }
}

fun d(TAG: String, message: String, e: Throwable?) {
    if (BuildConfig.DEBUG) {
        Log.e(TAG, message, e)
    }
}