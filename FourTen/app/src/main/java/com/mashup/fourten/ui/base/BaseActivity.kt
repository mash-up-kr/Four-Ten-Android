package com.mashup.fourten.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.mashup.fourten.BR

/**
 * Created by Namget on 2020.07.25.
 */
abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes
    val layoutRes: Int
) : AppCompatActivity() {
    abstract val viewModel: VM
    protected val binding: B by lazy {
        DataBindingUtil.setContentView<B>(this, layoutRes)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
    }

        binding.run {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.viewModel, viewModel)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}