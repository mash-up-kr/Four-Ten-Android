package com.mashup.fourten.data.repository

import com.mashup.fourten.data.model.HabitItem
import io.reactivex.Flowable
import io.reactivex.Single

interface HabitRepository {
    fun getHabitList() : Flowable<List<HabitItem>>

    fun getHabitDetail() : Single<HabitItem>

}