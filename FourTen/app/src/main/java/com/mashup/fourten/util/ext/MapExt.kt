package com.mashup.fourten.util.ext

/**
 * Created by Namget on 2020.07.26.
 */
fun<T> Map<String,T>.getOrDefaultNougat(key : String, default : T) : T{
   return this?.get(key) ?: default
}