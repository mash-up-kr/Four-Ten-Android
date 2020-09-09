package com.mashup.fourten.data.remote.source

import com.google.gson.JsonElement
import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import io.reactivex.disposables.Disposable

interface FruitRemoteDataSource {

    fun fetchCompletedFruits(
        callback: BaseResponse<BaseResponseData<List<Habit>>>
    ): Disposable

    fun signInCheck(callback: BaseResponse<BaseResponseData<JsonElement>>): Disposable
}