package com.mashup.fourten.ui.habitmake

import android.view.View
import android.widget.RadioGroup
import android.widget.ToggleButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mashup.fourten.data.repository.FruitRepositorylmpl
import com.mashup.fourten.ui.base.BaseViewModel

class HabitMakeViewModel (val repo : FruitRepositorylmpl): BaseViewModel(){
    private val _allweekCheck = MutableLiveData<Boolean>()
    private val _weekCheck = MutableLiveData<Boolean>()
    val allweekCheck : LiveData<Boolean> = _allweekCheck
    val weekCheck: LiveData<Boolean> = _weekCheck

    fun onToggle(btn: View) {
        val radioGroup = (btn.parent as RadioGroup)
        for (index in 0 until radioGroup.childCount) {
            val child = radioGroup.getChildAt(index) as ToggleButton
            if(child.id != btn.id)
                child.isChecked = false
        }
    }

    fun onToggleAll(btn:View){
        val radioGroup = (btn.parent as RadioGroup)
        var check = true
        for (index in 0 until radioGroup.childCount) {
            val child = radioGroup.getChildAt(index) as ToggleButton
            if(!child.isChecked)
                check = false
        }
        _allweekCheck.value = check
    }

    fun clickEveryWeek(btn: View) {
        _weekCheck.value = (btn as ToggleButton).isChecked
    }
}