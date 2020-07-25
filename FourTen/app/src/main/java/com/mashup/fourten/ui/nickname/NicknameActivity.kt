package com.mashup.fourten.ui.nickname

import com.mashup.fourten.R
import com.mashup.fourten.databinding.ActivityNicknameBinding
import com.mashup.fourten.ui.base.BaseActivity

class NicknameActivity : BaseActivity<ActivityNicknameBinding, NicknameViewModel>(R.layout.activity_nickname) {
    override val viewModel: NicknameViewModel
        get() = NicknameViewModel()
}