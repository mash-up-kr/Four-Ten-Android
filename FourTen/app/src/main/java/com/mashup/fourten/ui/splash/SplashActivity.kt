package com.mashup.fourten.ui.splash

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.mashup.fourten.BR
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivitySplashBinding
import com.mashup.fourten.ui.base.BaseActivity
import com.mashup.fourten.ui.login.LoginActivity
import com.mashup.fourten.ui.main.MainActivity
import com.mashup.fourten.ui.nickname.NicknameActivity
import com.mashup.fourten.ui.nickname.NicknameViewModel
import com.mashup.fourten.util.ext.start
import org.koin.android.ext.android.inject


class SplashActivity :
    BaseActivity<ActivitySplashBinding, SplashViewModel>(R.layout.activity_splash) {
    override val viewModel: SplashViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.setVariable(BR.viewModel, viewModel)
        val sf = getSharedPreferences("sFile", MODE_PRIVATE)
        val token = sf.getString("ServerToken", "")
        if (token != null) {
            viewModel.signInCheck(token)
        } else {
            start(LoginActivity::class, {})
            finish()
        }
        viewModel.checkedSignInField.observe(this, Observer {
            it.getContentIfNotHandled()?.let { // Only proceed if the event has never been handled
                start(MainActivity::class, {})
                finish()
            }
        })
    }
}


