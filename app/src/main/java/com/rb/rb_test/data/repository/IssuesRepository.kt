package com.rb.rb_test.data.repository

import com.rb.rb_test.data.model.Issue
import com.rb.rb_test.utils.parsers.CSVParser
import io.reactivex.Single
import javax.inject.Inject

class IssuesRepository @Inject constructor(private val csvParser: CSVParser) : IIssuesRepository {

    override fun getIssues(): Single<List<Issue>> {
        return Single.fromCallable {
            csvParser.parseFile("issues.csv")
        }
    }
}