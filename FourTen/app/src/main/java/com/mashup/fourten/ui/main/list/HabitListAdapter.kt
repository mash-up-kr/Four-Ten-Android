package com.mashup.fourten.ui.main.list

import com.mashup.fourten.R
import com.mashup.fourten.data.model.Habit
import com.mashup.fourten.databinding.ItemMainListBinding
import com.mashup.fourten.ui.base.BaseRecyclerAdapter

class HabitListAdapter : BaseRecyclerAdapter<Habit, ItemMainListBinding>(
    R.layout.item_main_list
)
