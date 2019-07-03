package com.rb.rb_test.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

interface IBaseViewModel {

}

abstract class BaseViewModel : ViewModel(), IBaseViewModel {

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
