package com.mashup.fourten.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.data.remote.source.HabitRemoteDataSource
import com.mashup.fourten.ui.base.BaseViewModel
import com.mashup.fourten.util.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val habitRemoteDataSource: HabitRemoteDataSource
) : BaseViewModel() {

    private val _startSettingActivity = MutableLiveData<Event<Unit>>()
    val startSettingActivity: LiveData<Event<Unit>>
        get() = _startSettingActivity

    private val _startHabitCompletedActivity = MutableLiveData<Event<Unit>>()
    val startHabitCompletedActivity: LiveData<Event<Unit>>
        get() = _startHabitCompletedActivity

    private val _startHabitMakeActivity = MutableLiveData<Event<Unit>>()
    val startHabitMakeActivity: LiveData<Event<Unit>>
        get() = _startHabitMakeActivity

    private val _startHabitListActivity = MutableLiveData<Event<Unit>>()
    val startHabitListActivity: LiveData<Event<Unit>>
        get() = _startHabitListActivity

    private val _habits = MutableLiveData<List<Habit>>(listOf())
    val habits: LiveData<List<Habit>>
        get() = _habits

    init {
        getHabitData()
    }

    private fun getHabitData() {
        habitRemoteDataSource.getHabitList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _habits.value = it
            }, {
                Log.d("error", it.localizedMessage)
            })
            .addTo(disposable)

        _habits.value?.map { it.doneCount = 5 }
        _habits.value = _habits.value
    }

    fun startHabitList() {
        _startHabitListActivity.value = Event(Unit)
    }

}