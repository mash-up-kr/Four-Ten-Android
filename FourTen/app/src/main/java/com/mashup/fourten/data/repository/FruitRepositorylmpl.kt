package com.mashup.fourten.data.repository

import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.model.response.HabitListResponseData
import com.mashup.fourten.data.remote.api.ApiService
import com.mashup.fourten.util.ext.observeSingle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FruitRepositorylmpl(
    private val api: ApiService
) : FruitRepository {
    override fun fetchCompletedFruits(
        callback: BaseResponse<BaseResponseData<List<HabitListResponseData>>>
    ): Disposable {
        return api.requestHabitList().observeSingle(callback)
    }

}