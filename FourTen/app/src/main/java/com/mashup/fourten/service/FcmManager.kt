package com.mashup.fourten.service

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.mashup.fourten.util.ext.d
import com.mashup.fourten.util.ext.e

/**
 * Created by Namget on 2020.07.25.
 */
class FcmManager {

    companion object {
        const val TAG = "FcmManager"
        fun getFirebaseToken(callback: (String) -> Unit) {
            FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        e(TAG, "getInstanceId failed", task.exception)
                        return@OnCompleteListener
                    }
                    // Get new Instance ID token
                    val token = task.result?.token ?: ""
                    // Log and toast
                    callback(token)
                    d(TAG, String.format("fcm registration token %s", token))
                })
        }
    }
}