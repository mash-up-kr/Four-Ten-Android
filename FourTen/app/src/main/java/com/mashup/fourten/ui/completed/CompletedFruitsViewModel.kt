package com.mashup.fourten.ui.completed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.fourten.data.local.JadoPreferences
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.model.response.HabitListResponseData
import com.mashup.fourten.data.repository.FruitRepositorylmpl
import com.mashup.fourten.ui.base.BaseViewModel

class CompletedFruitsViewModel(val repo: FruitRepositorylmpl) : BaseViewModel() {

    private val _userData = MutableLiveData<List<HabitListResponseData>>()
    val userData: LiveData<List<HabitListResponseData>> = _userData

    fun requestHabitList() {
        repo.fetchCompletedFruits(
            object : BaseResponse<BaseResponseData<List<HabitListResponseData>>> {
                override fun onSuccess(data: BaseResponseData<List<HabitListResponseData>>) {
                    _userData.value = data.responseData
                }

                override fun onError(throwable: Throwable) {
                }

                override fun onLoading() {
                }

                override fun onLoaded() {
                }
            }).also { disposable.add(it) }

    }
}