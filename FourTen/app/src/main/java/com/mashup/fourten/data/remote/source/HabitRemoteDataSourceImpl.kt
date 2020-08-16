package com.mashup.fourten.data.remote.source

import com.mashup.fourten.data.model.HabitItem
import com.mashup.fourten.data.remote.api.ApiService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class HabitRemoteDataSourceImpl(
    private val api: ApiService
): HabitRemoteDataSource {

    override fun getHabitList(): Single<List<HabitItem>> {
        return api.getHabitList()
            .map { it.responseData }
            .subscribeOn(Schedulers.io())
    }

//    override fun getHabitDetail(): Single<HabitItem> {
//
//    }

}