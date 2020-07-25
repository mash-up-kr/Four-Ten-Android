package com.mashup.fourten.ui.splash

import android.os.Bundle
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivitySplashBinding
import com.mashup.fourten.ui.base.BaseActivity
import android.os.Handler
import com.mashup.fourten.ui.login.LoginActivity
import com.mashup.fourten.ui.main.MainActivity
import com.mashup.fourten.util.ext.start

class SplashActivity :
    BaseActivity<ActivitySplashBinding, SplashViewModel>(R.layout.activity_splash) {
    private val SPLASH_TIME_OUT = 3000L
    override val viewModel: SplashViewModel
        get() = SplashViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed(
            {
                start(kClass = LoginActivity::class)
                finish()
            }, SPLASH_TIME_OUT
        )
    }
}