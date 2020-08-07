package com.mashup.fourten.ui.splash

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.Observer
import com.mashup.fourten.R
import com.mashup.fourten.data.local.JadoPreferences
import com.mashup.fourten.databinding.ActivitySplashBinding
import com.mashup.fourten.ui.base.BaseActivity
import com.mashup.fourten.ui.login.LoginActivity
import com.mashup.fourten.ui.main.MainActivity
import com.mashup.fourten.util.ext.start
import org.koin.android.ext.android.inject


class SplashActivity :
    BaseActivity<ActivitySplashBinding, SplashViewModel>(R.layout.activity_splash) {

    override val viewModel: SplashViewModel by inject()

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        JadoPreferences.init(this)
        super.onCreate(savedInstanceState)
        handler.postDelayed({
            if (!JadoPreferences.ptToken.isNullOrEmpty()) {
                viewModel.signInCheck()
            } else {
                start(LoginActivity::class, {})
                finish()
            }
        }, 3000)

        viewModel.checkedSignInField.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                if (it) {
                    start(MainActivity::class, {})
                    finish()
                } else {
                    start(LoginActivity::class, {})
                    finish()
                }
            }
        })
    }
}
