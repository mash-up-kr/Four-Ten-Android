package com.mashup.fourten.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import com.mashup.fourten.R
import com.mashup.fourten.data.local.JadoPreferences
import com.mashup.fourten.databinding.ActivitySplashBinding
import com.mashup.fourten.ui.base.BaseActivity
import com.mashup.fourten.ui.completed.CompletedFruitsActivity
import com.mashup.fourten.ui.login.LoginActivity
import com.mashup.fourten.util.EventObserver
import com.mashup.fourten.util.ext.e
import com.mashup.fourten.util.ext.start
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashActivity :
    BaseActivity<ActivitySplashBinding, SplashViewModel>(R.layout.activity_splash) {

    override val viewModel: SplashViewModel by viewModel()

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        JadoPreferences.init(this)
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        handler.postDelayed({
            if (!JadoPreferences.ptToken.isNullOrEmpty()) {
                viewModel.signInCheck()
            } else {
                start(LoginActivity::class, {})
                finish()
            }
        }, 3000)
        viewModel.checkedSignInField.observe(this, EventObserver<Boolean> {
            when (it) {
                true -> {
                    start(CompletedFruitsActivity::class, {})
                    finish()
                }
                false -> {
                    start(LoginActivity::class, {})
                    finish()
                }
            }
        })
    }
}

