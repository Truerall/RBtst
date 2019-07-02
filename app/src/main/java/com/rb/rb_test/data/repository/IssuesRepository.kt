package com.rb.rb_test.data.repository

import com.rb.rb_test.data.model.Issue
import io.reactivex.Single

class IssuesRepository : IIssuesRepository {
    override fun getIssues(): Single<List<Issue>> {
        return Single.fromCallable {
                parseCSV()
        }
    }

    private fun parseCSV(): List<Issue> {

        return emptyList<Issue>()
    }

}