package com.mashup.fourten.data.repository

import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.model.response.HabitListResponseData
import io.reactivex.disposables.Disposable

interface FruitRepositoryInterface {
    fun fetchCompletedFruits(
        callback: BaseResponse<BaseResponseData<List<HabitListResponseData>>>
    ): Disposable
}