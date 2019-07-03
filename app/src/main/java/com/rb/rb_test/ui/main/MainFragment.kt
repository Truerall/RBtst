package com.rb.rb_test.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.rb.rb_test.R
import com.rb.rb_test.base.BaseVMFragment
import com.rb.rb_test.base.BaseViewModel
import com.rb.rb_test.data.model.Issue

class MainFragment : BaseVMFragment<IMainViewModelContract>() {

    override val modelClass: Class<out BaseViewModel>
        get() = MainViewModel::class.java

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel.errorEventLiveData.observeEvent(viewLifecycleOwner, this::handleError)
        viewModel.issuesLiveData.observeNonNull(viewLifecycleOwner, this::displayData)
        fetchData()
        return inflater.inflate(R.layout.frg_main, container, false)
    }

    private fun displayData(issuesList: List<Issue>) {
        //TODO bind data
    }

    private fun fetchData() {
        if (!viewModel.isDataAvailable()) {
            viewModel.getIssues()
        }
    }

    private fun handleError(errorMessage: String) {
        view?.let {
            Snackbar.make(it, errorMessage, Snackbar.LENGTH_LONG).show()
        }
    }
}
