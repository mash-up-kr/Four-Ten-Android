package com.mashup.fourten.data.remote.source

import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.data.remote.api.FruitApiService
import io.reactivex.Single

class HabitRemoteDataSourceImpl(
    private val api: FruitApiService
): HabitRemoteDataSource {

    override fun getHabitList(): Single<List<Habit>> {
        return api.requestHabitList()
            .map { it.responseData }
    }

//    override fun getHabitDetail(): Single<HabitItem> {
//
//    }

}