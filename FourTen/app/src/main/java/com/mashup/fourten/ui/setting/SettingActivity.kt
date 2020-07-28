package com.mashup.fourten.ui.setting

import android.os.Bundle
import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivitySettingBinding
import com.mashup.fourten.service.FcmManager
import com.mashup.fourten.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingActivity : BaseActivity<ActivitySettingBinding,SettingViewModel>(R.layout.activity_setting){

    override val viewModel: SettingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FcmManager.getFirebaseToken {

        }

    }
}