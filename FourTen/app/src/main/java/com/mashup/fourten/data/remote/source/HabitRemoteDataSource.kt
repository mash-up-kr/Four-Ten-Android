package com.mashup.fourten.data.remote.source

import com.mashup.fourten.data.model.HabitItem
import com.mashup.fourten.data.model.response.HabitListResponseData
import io.reactivex.Single

interface HabitRemoteDataSource {
    fun getHabitList() : Single<List<HabitListResponseData>>

//    fun getHabitDetail() : Single<HabitItem>

}