package com.mashup.fourten.ui.main.list

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

class HabitListViewModel(val habitRemoteDataSource: HabitRemoteDataSource) : BaseViewModel() {

    private val _habits = MutableLiveData<List<Habit>>()
    val habits: LiveData<List<Habit>> = _habits

    private val _finish = MutableLiveData<Event<Unit>>()
    val finish: LiveData<Event<Unit>> = _finish

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
    }

    fun finishEvent() {
        _finish.value = Event(Unit)
    }

}
