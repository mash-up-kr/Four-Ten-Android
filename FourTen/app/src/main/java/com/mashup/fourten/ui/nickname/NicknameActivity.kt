package com.mashup.fourten.ui.nickname

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.mashup.fourten.BR
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivityNicknameBinding
import com.mashup.fourten.ui.base.BaseActivity
import com.mashup.fourten.ui.main.MainActivity
import com.mashup.fourten.util.ext.start
import org.koin.android.ext.android.inject

class NicknameActivity :
    BaseActivity<ActivityNicknameBinding, NicknameViewModel>(R.layout.activity_nickname) {
    override val viewModel: NicknameViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        viewModel.toastField.observe(this, Observer {
            it.getContentIfNotHandled()?.let { // Only proceed if the event has never been handled
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.loginField.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                start(MainActivity::class)
                finish()
            }
        })
    }
}