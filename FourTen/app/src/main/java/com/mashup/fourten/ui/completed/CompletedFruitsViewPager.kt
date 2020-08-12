package com.mashup.fourten.ui.completed

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CompletedFruitsViewPager(activity: CompletedFruitsActivity) : FragmentStateAdapter(activity) {
    companion object {
        const val STATE = "state"
    }

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> makeStateFragment("DONE")
            1 -> makeStateFragment("FAIL")
            else -> makeStateFragment("")
        }
    }

    fun makeStateFragment(state: String): Fragment {
        val fragment = CompletedFruitsFragment()
        val bundle = Bundle()
        bundle.putString(STATE, state)
        fragment.arguments = bundle
        return fragment
    }
}

