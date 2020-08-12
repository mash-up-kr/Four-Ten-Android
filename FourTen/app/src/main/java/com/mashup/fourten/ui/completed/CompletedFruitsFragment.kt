package com.mashup.fourten.ui.completed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mashup.fourten.R
import com.mashup.fourten.databinding.FragmentCompletedFruitsBinding
import com.mashup.fourten.ui.completed.CompletedFruitsViewPager.Companion.STATE
import com.mashup.fourten.util.ext.e

class CompletedFruitsFragment() : Fragment() {

    lateinit var state: String

    val viewModel: CompletedFruitsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        state = this.arguments?.getString(STATE) ?: ""
        val binding: FragmentCompletedFruitsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_completed_fruits, container, false)
        binding.viewModel = viewModel
        binding.fragment = this
        return binding.root
    }
}