package com.mashup.fourten.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivityMainBinding
import com.mashup.fourten.ui.base.BaseActivity
import com.mashup.fourten.util.EventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {
    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setup()
    }

    private fun setup() {
        binding.typeStatic = MainViewModel.Companion
        viewModel.setObserves()

    }

    private fun MainViewModel.setObserves() {
        startSettingActivity.observe(this@MainActivity, EventObserver {
            //TODO : intent SettingActivity
        })
        startHabitCompletedActivity.observe(this@MainActivity, EventObserver {
            //TODO : intent HabitCompletedActivity
        })
        startHabitMakeActivity.observe(this@MainActivity, EventObserver {
            //TODO : intent HabitMakeActivity
        })
        viewType.observe(this@MainActivity, Observer {
            //TODO : change Fragment (card/list)
        })
    }
}