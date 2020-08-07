package com.mashup.fourten.di

import com.mashup.fourten.data.repository.SignRepositoryImpl
import com.mashup.fourten.ui.completed.CompletedViewModel
import com.mashup.fourten.ui.login.LoginViewModel
import com.mashup.fourten.ui.nickname.NicknameActivity
import com.mashup.fourten.ui.nickname.NicknameViewModel
import com.mashup.fourten.ui.setting.SettingViewModel
import com.mashup.fourten.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module(override = true) {

    viewModel {
        SplashViewModel(get())
    }

    viewModel {
        LoginViewModel(get())
    }

    viewModel {
        NicknameViewModel(get())
    }

    viewModel {
        SettingViewModel()
    }

    viewModel {
        CompletedViewModel(get())
    }
}