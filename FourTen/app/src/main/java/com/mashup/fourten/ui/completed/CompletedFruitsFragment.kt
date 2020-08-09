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

class CompletedFruitsFragment(val state: String) : Fragment() {

    val viewModel: CompletedFruitsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCompletedFruitsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_completed_fruits, container, false)
        binding.viewModel = viewModel
        binding.fragment = this
        return binding.root
    }
}