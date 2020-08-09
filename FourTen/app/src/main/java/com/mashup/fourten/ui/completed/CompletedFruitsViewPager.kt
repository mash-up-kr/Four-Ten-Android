package com.mashup.fourten.ui.completed

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CompletedFruitsViewPager(activity: CompletedFruitsActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CompletedFruitsFragment("DONE")
            1 -> CompletedFruitsFragment("FAIL")
            else -> CompletedFruitsFragment("")
        }
    }
}

