package com.mashup.fourten.data.repository

import com.mashup.fourten.data.model.HabitItem
import com.mashup.fourten.data.model.response.HabitListResponseData
import io.reactivex.Flowable
import io.reactivex.Single

interface HabitRepository {
    fun getHabitList() : Flowable<List<HabitListResponseData>>

    fun getHabitDetail() : Single<HabitItem>

}