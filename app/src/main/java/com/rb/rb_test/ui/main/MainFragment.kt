package com.rb.rb_test.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.rb.rb_test.R
import com.rb.rb_test.ui.base.BaseInjectionFragment
import com.rb.rb_test.utils.parsers.CSVParser
import javax.inject.Inject

class MainFragment : BaseInjectionFragment() {

    @Inject lateinit var csvParser: CSVParser
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.frg_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        Log.d("fff","fff csv parser> "+ csvParser.testText)
        // TODO: Use the ViewModel
    }
}
