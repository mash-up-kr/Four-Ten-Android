package com.mashup.fourten.data.repository

import com.google.gson.JsonElement
import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import io.reactivex.disposables.Disposable

interface FruitRepository {

    fun fetchCompletedFruits(
        callback: BaseResponse<BaseResponseData<List<Habit>>>
    ): Disposable

    fun signInCheck(callback: BaseResponse<BaseResponseData<JsonElement>>): Disposable
}