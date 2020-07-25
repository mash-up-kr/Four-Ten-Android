package com.mashup.fourten.ui.login

import android.os.Bundle
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivityLoginBinding
import com.mashup.fourten.ui.base.BaseActivity

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {
    override val viewModel: LoginViewModel
        get() = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}