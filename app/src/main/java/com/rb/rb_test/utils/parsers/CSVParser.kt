package com.rb.rb_test.utils.parsers

import android.app.Application
import com.rb.rb_test.data.model.Issue
import com.rb.rb_test.utils.Utils
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class CSVParser(private val context: Application) {

    fun parseFile(fileName: String): List<Issue> {
        val issues = ArrayList<Issue>()

        val inputStream = context.assets.open(fileName)

        val br = BufferedReader(InputStreamReader(inputStream) as Reader?)

        br.readLine()
        var issueCsvLine: List<String>
        br.forEachLine {
            issueCsvLine = it.replace("\"","", true).split(',')

            issues.add(
                Issue(
                    issueCsvLine[0],
                    issueCsvLine[1],
                    issueCsvLine[2].toInt(),
                    parseDate(issueCsvLine[3])
                )
            )
        }

        return issues
    }

    private fun parseDate(dateString: String): Date {
        return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Utils.getLocale(context)).parse(dateString)
    }
}