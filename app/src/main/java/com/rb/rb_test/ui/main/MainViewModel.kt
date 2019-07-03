package com.rb.rb_test.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.rb.rb_test.base.BaseViewModel
import com.rb.rb_test.base.IBaseViewModel
import com.rb.rb_test.data.model.Issue
import com.rb.rb_test.data.repository.IIssuesRepository
import com.rb.rb_test.utils.architecture.Event
import com.rb.rb_test.utils.architecture.EventLiveData
import com.rb.rb_test.utils.architecture.NonNullMutableLiveData
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

interface IMainViewModelContract : IBaseViewModel {
    val errorEventLiveData: EventLiveData<String>
    val issuesLiveData: NonNullMutableLiveData<List<Issue>>

    fun isDataAvailable() : Boolean
    fun getIssues()
}

class MainViewModel @Inject constructor(private val repository: IIssuesRepository) : BaseViewModel(),
    IMainViewModelContract {

    override fun isDataAvailable(): Boolean {
        return repository.isDataAvailable()
    }

    override val issuesLiveData = NonNullMutableLiveData<List<Issue>>()
    override val errorEventLiveData = EventLiveData<String>()

    override fun getIssues() {
        compositeDisposable += repository.getIssues()
            .subscribeBy(
                onSuccess = {
                    issuesLiveData.value = it
                },
                onError = {
                    errorEventLiveData.value = Event("Error during parsing of csv file")
                }
            )
    }
}
