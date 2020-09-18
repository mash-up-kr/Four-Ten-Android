package com.mashup.fourten.data.model

data class Habit(
    val alarmTime: Int,
    val createDate: String,
    val diarys: List<Any>,
    val doDay: String,
    var doneCount: Int,
    val duration: Int,
    val habitSeq: Int,
    val life: Int,
    val state: String,
    val title: String,
    val totalCount: Int
)

enum class State { ING, DONE, FAIL }