package com.mashup.fourten.data.remote.source

import com.google.gson.JsonElement
import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.data.model.request.SignInRequestData
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.remote.api.FruitApiService
import com.mashup.fourten.data.repository.SnsType
import com.mashup.fourten.util.ext.observeSingle
import io.reactivex.disposables.Disposable

class FruitRemoteDataSourceImpl(
    private val FruitApi: FruitApiService
) : FruitRemoteDataSource {

    override fun fetchCompletedFruits(
        callback: BaseResponse<BaseResponseData<List<Habit>>>
    ): Disposable {
        return FruitApi.requestHabitList().observeSingle(callback)
    }

    override fun signInCheck(
        callback: BaseResponse<BaseResponseData<JsonElement>>
    ): Disposable {
        return FruitApi.requestSignInCheck(SignInRequestData(SnsType.NONE.snsType, ""))
            .observeSingle(callback)
    }
}