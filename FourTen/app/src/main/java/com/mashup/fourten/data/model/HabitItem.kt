package com.mashup.fourten.data.model
import com.google.gson.annotations.SerializedName


data class HabitItem(
    @SerializedName("alarmTime")
    val alarmTime: Int = 0,
    @SerializedName("createDate")
    val createDate: String = "",
    @SerializedName("diarys")
    val diarys: List<Any> = listOf(),
    @SerializedName("doDay")
    val doDay: String = "",
    @SerializedName("doneCount")
    val doneCount: Int = 0,
    @SerializedName("duration")
    val duration: Int = 0,
    @SerializedName("habitSeq")
    val habitSeq: Int = 0,
    @SerializedName("life")
    val life: Int = 0,
    @SerializedName("state")
    val state: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("totalCount")
    val totalCount: Int = 0
)