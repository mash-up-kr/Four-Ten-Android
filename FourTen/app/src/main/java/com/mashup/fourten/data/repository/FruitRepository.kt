package com.mashup.fourten.data.repository

import com.google.gson.JsonElement
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.model.response.HabitListResponseData
import io.reactivex.disposables.Disposable

interface FruitRepository {

    fun fetchCompletedFruits(
        callback: BaseResponse<BaseResponseData<List<HabitListResponseData>>>
    ): Disposable

    fun signInCheck(callback: BaseResponse<BaseResponseData<JsonElement>>): Disposable
}