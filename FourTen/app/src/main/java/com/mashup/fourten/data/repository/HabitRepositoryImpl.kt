package com.mashup.fourten.data.repository

import com.mashup.fourten.data.model.HabitItem
import com.mashup.fourten.data.model.response.HabitListResponseData
import com.mashup.fourten.data.remote.source.HabitRemoteDataSource
import io.reactivex.Flowable
import io.reactivex.Single

class HabitRepositoryImpl(
    private val habitRemote: HabitRemoteDataSource
) : HabitRepository {
    override fun getHabitList(): Flowable<List<HabitListResponseData>> {
        return habitRemote.getHabitList()
            .toFlowable()
    }

    override fun getHabitDetail(): Single<HabitItem> {
        TODO("Not yet implemented")
    }
}