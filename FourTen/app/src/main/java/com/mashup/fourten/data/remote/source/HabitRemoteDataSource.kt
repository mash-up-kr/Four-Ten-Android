package com.mashup.fourten.data.remote.source

import com.mashup.fourten.data.model.Habit
import io.reactivex.Single

interface HabitRemoteDataSource {
    fun getHabitList(): Single<List<Habit>>

//    fun getHabitDetail() : Single<HabitItem>

}