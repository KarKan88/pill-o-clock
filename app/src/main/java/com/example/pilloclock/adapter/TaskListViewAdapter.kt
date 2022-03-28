package com.example.pilloclock.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import com.example.pilloclock.R
import com.example.pilloclock.data.AppDatabase
import com.example.pilloclock.data.model.Task
import com.example.pilloclock.data.repo.PillRepository

class TaskListViewAdapter(private val context: Activity,
                          private val tasks: MutableList<Task>,
                          )
    : ArrayAdapter<Task>(context, R.layout.task_list, tasks) {
    private val pillRepos = PillRepository(AppDatabase.getDatabase(context).pillDao())

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.task_list, null, true)

        val taskCheckBox = rowView.findViewById(R.id.taskCheckBox) as CheckBox
        taskCheckBox.text = tasks[position].taskName
        taskCheckBox.isChecked = tasks[position].isCompleted
        taskCheckBox.setOnCheckedChangeListener { compoundButton, b ->
            pillRepos.updatePillTaken(tasks[position].pillId, b)
        }
        return rowView
    }

}