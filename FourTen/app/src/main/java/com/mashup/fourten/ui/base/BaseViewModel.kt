package com.mashup.fourten.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import iclass.mathflat.teacher.util.Event
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