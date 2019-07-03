package com.rb.rb_test.data.repository

import android.util.Log
import com.rb.rb_test.data.model.Issue
import com.rb.rb_test.utils.parsers.CSVParser
import io.reactivex.Single
import javax.inject.Inject

class IssuesRepository @Inject constructor(private val csvParser: CSVParser) : IIssuesRepository {

    override fun getIssues(): Single<List<Issue>> {
        return Single.fromCallable {
                parseCSV()
        }
    }

    private fun parseCSV(): List<Issue> {
        Log.d("fff","fff issues csv parser> "+ csvParser.testText)
        return emptyList<Issue>()
    }

}