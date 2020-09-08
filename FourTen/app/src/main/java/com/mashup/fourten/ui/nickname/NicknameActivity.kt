package com.mashup.fourten.ui.nickname

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivityNicknameBinding
import com.mashup.fourten.ui.base.BaseActivity
import com.mashup.fourten.ui.main.MainActivity
import com.mashup.fourten.util.EventObserver
import com.mashup.fourten.util.ext.start
import com.mashup.fourten.util.ext.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class NicknameActivity :
    BaseActivity<ActivityNicknameBinding, NicknameViewModel>(R.layout.activity_nickname) {
    override val viewModel: NicknameViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init() {
        binding.activity = this

        viewModel.toastField.observe(this, EventObserver<Int> {
            this.toast(getString(it))
        })

        viewModel.loginField.observe(this, EventObserver<Int> {
            start(MainActivity::class)
            finish()
        })

    }
}