package com.mashup.fourten.ui.completed

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mashup.fourten.databinding.ItemCompleteFruitsBinding

class CompletedFruitsAdapter(val viewModel: CompletedFruitsViewModel, private val state: String) :
    RecyclerView.Adapter<CompletedFruitsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CompletedFruitsAdapter.ViewHolder {

        val binding =
            ItemCompleteFruitsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, state)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewModel, position);
    }

    override fun getItemCount() =
        viewModel.userData.value?.filter { v -> v.state == state }?.size ?: 0


    class ViewHolder(val binding: ItemCompleteFruitsBinding, private val state: String) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            viewModel: CompletedFruitsViewModel,
            position: Int
        ) {
            binding.userData =
                viewModel.userData.value?.filter { v -> v.state == state }?.get(position)
        }
    }
}
