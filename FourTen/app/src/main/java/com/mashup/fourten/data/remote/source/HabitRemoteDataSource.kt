package com.mashup.fourten.data.remote.source

import com.mashup.fourten.data.model.HabitItem
import io.reactivex.Single

interface HabitRemoteDataSource {
    fun getHabitList() : Single<List<HabitItem>>

//    fun getHabitDetail() : Single<HabitItem>

}