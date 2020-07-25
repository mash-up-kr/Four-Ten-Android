package com.mashup.fourten.util

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionManager {
    companion object {
        fun checkPermission(activity: Activity, vararg permissions: String, requestCode: Int) {
            // Here, thisActivity is the current activity
            val notGrantedPermission = arrayListOf<String>()
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(
                        activity,
                        permission
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    notGrantedPermission.add(permission)
                }
            }

            ActivityCompat.requestPermissions(
                activity,
                permissions,
                requestCode
            )

        }
    }
}