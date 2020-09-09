package com.mashup.fourten.ui.habitmake

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.ToggleButton
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivityHabitMakeBinding
import com.mashup.fourten.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HabitMakeActivity:
    BaseActivity<ActivityHabitMakeBinding, HabitMakeViewModel>(R.layout.activity_habit_make) {

    override val viewModel: HabitMakeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }




}