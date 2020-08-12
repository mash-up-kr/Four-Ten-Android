package com.mashup.fourten.ui.nickname

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivityNicknameBinding
import com.mashup.fourten.ui.base.BaseActivity
import com.mashup.fourten.ui.main.MainActivity
import com.mashup.fourten.util.ext.start
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

        viewModel.toastField.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
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