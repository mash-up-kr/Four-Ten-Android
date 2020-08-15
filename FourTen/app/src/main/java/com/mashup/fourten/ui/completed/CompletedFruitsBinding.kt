package com.mashup.fourten.ui.completed

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter(value = ["bind_viewModel", "bind_state"])
fun setBindItems(view: RecyclerView, viewModel: CompletedFruitsViewModel, state: String) {
    view.adapter = CompletedFruitsAdapter(viewModel, state)
}