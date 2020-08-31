package com.mashup.fourten.ui.main.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.data.remote.source.HabitRemoteDataSource
import com.mashup.fourten.ui.base.BaseViewModel
import io.reactivex.schedulers.Schedulers

class HabitListViewModel(val habitRemoteDataSource: HabitRemoteDataSource) : BaseViewModel() {

    private val _habits = MutableLiveData<List<Habit>>()
    val habits: LiveData<List<Habit>> = _habits

    fun getHabits() {
        habitRemoteDataSource.getHabitList()
            .subscribeOn(Schedulers.io())
            .subscribe({
                _habits.value = it
            }, {
                Log.d("errorrrr", it.localizedMessage)
            })
    }

}
