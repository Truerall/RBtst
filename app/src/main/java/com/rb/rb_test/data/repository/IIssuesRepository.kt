package com.rb.rb_test.data.repository

import com.rb.rb_test.data.model.Issue
import io.reactivex.Single

interface IIssuesRepository {
    fun getIssues() : Single<List<Issue>>
    fun isDataAvailable() : Boolean
}