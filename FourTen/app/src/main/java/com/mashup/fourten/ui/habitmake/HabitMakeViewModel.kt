package com.mashup.fourten.ui.habitmake

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HabitMakeViewModel : ViewModel() {
    private val _priodValue = MutableLiveData<Int>()
    val priodValue : LiveData<Int>
        get() = _priodValue

    private val _weekValue = MutableLiveData<Int>()
    val weekValue : LiveData<Int>
        get() = _weekValue

    
}