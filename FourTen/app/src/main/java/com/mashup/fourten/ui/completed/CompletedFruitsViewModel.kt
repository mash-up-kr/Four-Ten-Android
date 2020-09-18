package com.mashup.fourten.ui.completed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.data.model.response.BaseResponse
import com.mashup.fourten.data.model.response.BaseResponseData
import com.mashup.fourten.data.remote.source.FruitRemoteDataSource
import com.mashup.fourten.ui.base.BaseViewModel

class CompletedFruitsViewModel(private val fruitDataSource: FruitRemoteDataSource) : BaseViewModel() {

    private val _userData = MutableLiveData<List<Habit>>()
    val userData: LiveData<List<Habit>> = _userData

    fun requestHabitList() {
        fruitDataSource.fetchCompletedFruits(
            object : BaseResponse<BaseResponseData<List<Habit>>> {
                override fun onSuccess(data: BaseResponseData<List<Habit>>) {
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
