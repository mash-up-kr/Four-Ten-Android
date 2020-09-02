package com.mashup.fourten.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.data.model.State
import com.mashup.fourten.data.remote.source.HabitRemoteDataSource
import com.mashup.fourten.ui.base.BaseViewModel
import com.mashup.fourten.util.Event

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

    private val _habitList = MutableLiveData<List<Habit>>()
    val habitList: LiveData<List<Habit>>
        get() = _habitList

    init {
        getMyHabit()
    }

    private fun getMyHabit() {
//        habitRemoteDataSource.getHabitList()

        _habitList.value = arrayListOf(
            Habit(
                0, "2020-09-02", listOf(), "", 10,
                5, 2, 2, State.ING.name, "영어단어 외우기", 20
            ),

            Habit(
                0, "2020-09-02", listOf(), "", 10,
                5, 2, 2, State.ING.name, "노래부르기", 20
            )
        )
    }


    fun startHabitList() {
        _startHabitListActivity.value = Event(Unit)
    }

}