package com.rb.rb_test.ui.main

import android.content.Context
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rb.rb_test.R
import com.rb.rb_test.data.model.Issue
import kotlinx.android.synthetic.main.item_issue.view.*

class MainIssueListAdapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    private var dataSet: List<Issue> = listOf()
    private val formatter = DateFormat.getDateFormat(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_issue, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvDataFirstName.text = dataSet[position].firstName
        holder.tvDataSurName.text = dataSet[position].surName
        holder.tvDataIssueCnt.text = dataSet[position].issueCount.toString()
        holder.tvDataBirthDate.text = formatter.format(dataSet[position].date)
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun setData(newDataSet: List<Issue>){
        this.dataSet = newDataSet
        notifyDataSetChanged()
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvDataFirstName = view.tv_data_first_name
    val tvDataSurName = view.tv_data_sur_name
    val tvDataIssueCnt = view.tv_data_issue_cnt
    val tvDataBirthDate = view.tv_data_birth_date
}