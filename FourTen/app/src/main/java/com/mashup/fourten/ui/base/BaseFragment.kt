package com.mashup.fourten.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<Binding : ViewDataBinding>(
    @LayoutRes
    protected val layoutResId: Int
) : Fragment(layoutResId) {

    protected val binding by lazy { DataBindingUtil.bind<Binding>(view!!)!! }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding {
            lifecycleOwner = viewLifecycleOwner
        }
    }

    protected fun binding(action: Binding.() -> Unit) {
        binding.run(action)
    }
}
