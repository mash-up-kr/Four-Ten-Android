package com.mashup.fourten.data.remote.source

import com.mashup.fourten.data.model.response.HabitListResponseData
import com.mashup.fourten.data.remote.api.FruitApiService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class HabitRemoteDataSourceImpl(
    private val api: FruitApiService
): HabitRemoteDataSource {

    override fun getHabitList(): Single<List<HabitListResponseData>> {
        return api.requestHabitList()
            .map { it.responseData }
            .subscribeOn(Schedulers.io())
    }

//    override fun getHabitDetail(): Single<HabitItem> {
//
//    }

}