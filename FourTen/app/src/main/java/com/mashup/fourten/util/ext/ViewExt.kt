package com.mashup.fourten.util.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.longToast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()

//startActivity<DetailActivity>()
inline fun <reified T : Activity> Context.startActivity(bundle: Bundle? = null, vararg flags: Int) {
    val intent = Intent(this, T::class.java)
    for (flag in flags) {
        intent.addFlags(flag)
    }
    if (bundle != null) intent.putExtras(bundle)
    startActivity(intent)
}

fun Activity.checkPermission(REQUEST_CODE: Int, vararg permissions: String) {
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
        REQUEST_CODE
    )
}


/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


//fun AppCompatActivity.replaceFragmentInActivity(fragment: _root_ide_package_.androidx.fragment.app.Fragment, frameId: Int) {
//    supportFragmentManager.transact {
//        replace(frameId, fragment)
//    }
//}
//
//fun AppCompatActivity.addFragmentToActivity(fragment: Fragment, tag: String) {
//    supportFragmentManager.transact {
//        add(fragment, tag)
//    }
//}
//
//private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
//    beginTransaction().apply {
//        action()
//    }.commit()
//}