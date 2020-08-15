package com.mashup.fourten.data.repository

import com.google.gson.JsonElement
import com.mashup.fourten.data.model.request.SignInRequestData
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.model.response.HabitListResponseData
import com.mashup.fourten.data.remote.api.FruitApiService
import com.mashup.fourten.data.remote.api.SignApiService
import com.mashup.fourten.util.ext.observeSingle
import io.reactivex.disposables.Disposable

class FruitRepositorylmpl(
    private val FruitApi: FruitApiService
) : FruitRepository {

    override fun fetchCompletedFruits(
        callback: BaseResponse<BaseResponseData<List<HabitListResponseData>>>
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