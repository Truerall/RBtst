package com.rb.rb_test.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.rb.rb_test.R
import com.rb.rb_test.base.BaseInjectionFragment
import com.rb.rb_test.base.BaseVMFragment
import com.rb.rb_test.base.BaseViewModel
import com.rb.rb_test.utils.parsers.CSVParser
import javax.inject.Inject

class MainFragment : BaseVMFragment<MainViewModel>() {

    override val modelClass: Class<out BaseViewModel>
        get() = MainViewModel::class.java

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.frg_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.test()
    }
}
