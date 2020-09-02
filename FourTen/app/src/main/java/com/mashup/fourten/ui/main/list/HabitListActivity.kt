package com.mashup.fourten.ui.main.list

import android.os.Bundle
import androidx.lifecycle.Observer
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivityHabitListBinding
import com.mashup.fourten.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HabitListActivity : BaseActivity<ActivityHabitListBinding, HabitListViewModel>(
    R.layout.activity_habit_list
) {

    override val viewModel: HabitListViewModel by viewModel()
    private val adapter by lazy { HabitListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.setObserves()
        initRecyclerView()

        viewModel.getHabits()
    }

    private fun HabitListViewModel.setObserves() {
        habits.observe(this@HabitListActivity, Observer { adapter.updateItems(it) })
    }

    private fun initRecyclerView() {
        binding.rvHabit.adapter = HabitListAdapter()
    }

}