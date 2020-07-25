package com.mashup.fourten.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.fourten.ui.base.BaseViewModel
import com.mashup.fourten.util.Event

class MainViewModel : BaseViewModel() {

    private val _startSettingActivity = MutableLiveData<Event<Unit>>()
    val startSettingActivity: LiveData<Event<Unit>>
        get() = _startSettingActivity

    private val _startHabitCompletedActivity = MutableLiveData<Event<Unit>>()
    val startHabitCompletedActivity: LiveData<Event<Unit>>
        get() = _startHabitCompletedActivity

    private val _startHabitMakeActivity = MutableLiveData<Event<Unit>>()
    val startHabitMakeActivity: LiveData<Event<Unit>>
        get() = _startHabitMakeActivity

    private val _viewType = MutableLiveData<Int>()
    val viewType: LiveData<Int>
        get() = _viewType

    init {
        _viewType.value = MAIN_VIEW_TYPE_LIST
    }

    fun changeViewType() {
        _viewType.value =
            if (viewType.value == MAIN_VIEW_TYPE_CARD_SLIDE) MAIN_VIEW_TYPE_LIST
            else MAIN_VIEW_TYPE_CARD_SLIDE
    }

    companion object {
        val MAIN_VIEW_TYPE_CARD_SLIDE = 0
        private const val MAIN_VIEW_TYPE_LIST = 1
    }

}