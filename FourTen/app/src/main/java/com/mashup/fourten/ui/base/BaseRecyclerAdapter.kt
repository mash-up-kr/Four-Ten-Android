package com.mashup.fourten.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mashup.fourten.BR

open class BaseRecyclerAdapter<ITEM : Any, BINDING : ViewDataBinding>(
    @LayoutRes val layoutResId: Int
) :
    RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder>() {

    val items = mutableListOf<ITEM>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = DataBindingUtil.inflate<BINDING>(
            LayoutInflater.from(parent.context), layoutResId, parent, false
        )
        return BaseViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class BaseViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Any) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }

    fun updateItems(updateItems: List<ITEM>) {
        items.run {
            clear()
            addAll(updateItems)
        }
        notifyDataSetChanged()
    }

    fun clearItems() {
        items.clear()
        notifyDataSetChanged()
    }

}