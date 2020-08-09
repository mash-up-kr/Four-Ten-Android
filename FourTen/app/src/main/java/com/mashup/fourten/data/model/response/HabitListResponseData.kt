package com.mashup.fourten.data.model.response

data class HabitListResponseData(
    val alarmTime: Int,
    val createDate: String,
    val diarys: List<Any>,
    val doDay: String,
    val doneCount: Int,
    val duration: Int,
    val habitSeq: Int,
    val life: Int,
    val state: String,
    val title: String,
    val totalCount: Int
)