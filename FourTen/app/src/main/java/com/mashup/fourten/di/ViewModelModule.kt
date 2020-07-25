package com.mashup.fourten.di

import com.mashup.fourten.ui.setting.SettingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory {
        SettingViewModel()
    }
}