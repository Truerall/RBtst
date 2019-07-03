package com.rb.rb_test.ui.main

import android.util.Log
import com.rb.rb_test.base.BaseViewModel
import com.rb.rb_test.data.repository.IIssuesRepository
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject


class MainViewModel @Inject constructor(private val repository: IIssuesRepository) : BaseViewModel() {

    fun test() {
        compositeDisposable += repository.getIssues().subscribeBy {
            Log.d("fff", "fff onSuccess")
        }
    }
}
