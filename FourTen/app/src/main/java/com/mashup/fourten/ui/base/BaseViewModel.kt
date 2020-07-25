package com.mashup.fourten.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Namget on 2020.07.25.
 */
abstract class BaseViewModel : ViewModel() {

    protected val disposable = CompositeDisposable()


    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }


}