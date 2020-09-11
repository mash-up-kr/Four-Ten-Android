package com.mashup.fourten.ui.main.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.data.model.State
import com.mashup.fourten.data.remote.source.HabitRemoteDataSource
import com.mashup.fourten.ui.base.BaseViewModel
import com.mashup.fourten.util.Event

class HabitListViewModel(val habitRemoteDataSource: HabitRemoteDataSource) : BaseViewModel() {

    private val _habits = MutableLiveData<List<Habit>>()
    val habits: LiveData<List<Habit>> = _habits

    private val _finish = MutableLiveData<Event<Unit>>()
    val finish: LiveData<Event<Unit>> = _finish

    init {
        getHabits()
    }

    fun getHabits() {
        _habits.value = arrayListOf(
            Habit(
                0, "2020-09-02", listOf(), "", 10,
                5, 2, 2, State.ING.name, "영어단어 외우기", 20
            ),

            Habit(
                0, "2020-09-02", listOf(), "", 10,
                5, 2, 2, State.ING.name, "노래부르기", 20
            ),

            Habit(
                0, "2020-09-02", listOf(), "", 10,
                5, 2, 2, State.ING.name, "노래부르기", 20
            ),

            Habit(
                0, "2020-09-02", listOf(), "", 10,
                5, 2, 2, State.ING.name, "노래부르기", 20
            ),

            Habit(
                0, "2020-09-02", listOf(), "", 10,
                5, 2, 2, State.ING.name, "노래부르기", 20
            )
        )
//        habitRemoteDataSource.getHabitList()
//            .subscribeOn(Schedulers.io())
//            .subscribe({
//                _habits.value = it
//            }, {
//                Log.d("errorrrr", it.localizedMessage)
//            })
    }

    fun finish() {
        _finish.value = Event(Unit)
    }

}
