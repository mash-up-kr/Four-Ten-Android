package com.mashup.fourten.ui.completed

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivityCompletedFruitsBinding
import com.mashup.fourten.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompletedFruitsActivity :
    BaseActivity<ActivityCompletedFruitsBinding, CompletedFruitsViewModel>(R.layout.activity_completed_fruits) {
    override val viewModel: CompletedFruitsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        binding.activity = this
        val tabLayout = findViewById<TabLayout>(R.id.tlTab)
        val pager = findViewById<ViewPager2>(R.id.pgCompletedFruits)
        pager.adapter = CompletedFruitsViewPager(this)
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            when (position) {
                0 -> tab.text = "달성한 목표"
                1 -> tab.text = "실패한 목표"
            }
        }.attach()
        viewModel.requestHabitList()
    }
}