package com.rb.rb_test.data.repository

import com.rb.rb_test.data.model.Issue
import com.rb.rb_test.utils.parsers.CSVParser
import com.rb.rb_test.utils.rx.AppSchedulerProvider
import io.reactivex.Single
import javax.inject.Inject

class IssuesRepository @Inject constructor(
    private val csvParser: CSVParser,
    private val schedulerProvider: AppSchedulerProvider
) : IIssuesRepository {

    var issuesList: List<Issue>? = null

    override fun isDataAvailable(): Boolean {
        return !issuesList.isNullOrEmpty()
    }

    override fun getIssues(): Single<List<Issue>> {
        return if (isDataAvailable()) {
            Single.just(issuesList)
        } else {
            Single.fromCallable { csvParser.parseFile("issues.csv") }
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSuccess {
                    issuesList = it
                }
        }
    }
}