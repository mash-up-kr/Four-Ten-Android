package com.mashup.fourten.di

import com.mashup.fourten.ui.completed.CompletedFruitsViewModel
import com.mashup.fourten.ui.habitmake.HabitMakeViewModel
import com.mashup.fourten.ui.login.LoginViewModel
import com.mashup.fourten.ui.main.MainViewModel
import com.mashup.fourten.ui.main.list.HabitListViewModel
import com.mashup.fourten.ui.nickname.NicknameViewModel
import com.mashup.fourten.ui.setting.SettingViewModel
import com.mashup.fourten.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module(override = true) {

    viewModel { SplashViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { NicknameViewModel(get()) }

    viewModel { MainViewModel(get()) }
    viewModel { HabitListViewModel(get()) }

    viewModel { CompletedFruitsViewModel(get()) }

    viewModel { SettingViewModel() }

    viewModel { CompletedFruitsViewModel(get()) }

    viewModel { HabitMakeViewModel(get()) }
}