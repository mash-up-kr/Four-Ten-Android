package com.mashup.fourten.util.ext

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

fun Activity.checkPermission(vararg permissions: String, requestCode: Int) {
    // Here, thisActivity is the current activity
    val notGrantedPermission = arrayListOf<String>()
    for (permission in permissions) {
        if (ContextCompat.checkSelfPermission(
                this,
                permission
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            notGrantedPermission.add(permission)
        }
    }

    ActivityCompat.requestPermissions(
        this,
        permissions,
        requestCode
    )

}