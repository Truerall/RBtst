package com.rb.rb_test.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.rb.rb_test.R
import com.rb.rb_test.base.BaseVMFragment
import com.rb.rb_test.base.BaseViewModel
import com.rb.rb_test.data.model.Issue
import kotlinx.android.synthetic.main.frg_main.*

class MainFragment : BaseVMFragment<IMainViewModelContract>() {

    private val adapter by lazy { MainIssueListAdapter(requireContext()) }

    override val modelClass: Class<out BaseViewModel>
        get() = MainViewModel::class.java

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel.errorEventLiveData.observeEvent(viewLifecycleOwner, this::handleError)
        viewModel.issuesLiveData.observeNonNull(viewLifecycleOwner, this::displayData)
        return inflater.inflate(R.layout.frg_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
        rv_issue_list.layoutManager = LinearLayoutManager(requireContext())
        rv_issue_list.adapter = adapter
    }

    private fun displayData(issuesList: List<Issue>) {
        adapter.setData(issuesList)
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
