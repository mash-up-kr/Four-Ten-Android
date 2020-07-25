package com.mashup.fourten.util.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

fun Context.start(kClass: KClass<out Activity>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, kClass.java)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

fun Fragment.start(kClass: KClass<out Activity>) {
    val intent = Intent(activity, kClass.java)
    startActivity(intent)
}

fun Context.start(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}
