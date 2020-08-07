package com.mashup.fourten.ui.completed

import android.os.Bundle
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivityCompletedBinding
import com.mashup.fourten.databinding.ActivityLoginBinding
import com.mashup.fourten.ui.base.BaseActivity
import com.mashup.fourten.ui.login.LoginViewModel
import org.koin.android.ext.android.inject

class CompletedActivity :
    BaseActivity<ActivityCompletedBinding, CompletedViewModel>(R.layout.activity_completed) {
    override val viewModel: CompletedViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}