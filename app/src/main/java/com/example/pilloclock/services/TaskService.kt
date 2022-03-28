package com.example.pilloclock.services

import android.content.Context
import com.example.pilloclock.data.AppDatabase
import com.example.pilloclock.data.model.Task
import com.example.pilloclock.data.repo.PillRepository
import java.text.SimpleDateFormat
import java.util.*

class TaskService(context: Context) {
    private val pillRepos = PillRepository(AppDatabase.getDatabase(context).pillDao())

    fun getTaskList(date: String): MutableList<Task> {
        val pills = pillRepos.getPills()
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        var tasks:MutableList<Task> = mutableListOf()

        pills.forEach {
            val start: Date = sdf.parse(it.startDate)
            val myDate: Date = sdf.parse(date)
            val end: Date = sdf.parse(it.endDate)
            if (it.pillsLeft!! > 0){
                val calendar = Calendar.getInstance()
                val date = calendar.time
                val todayDate = SimpleDateFormat("EE", Locale.ENGLISH).format(date.time)
                if (it.days?.contains(todayDate) == true) {
                    tasks.add(Task(it.id,it.name+" needs to be taken at "+it.time, it.isTaken == true))
                }
            } else if (myDate.before(end) && start.before(end)){
                val calendar = Calendar.getInstance()
                val date = calendar.time
                val todayDate = SimpleDateFormat("EE", Locale.ENGLISH).format(date.time)
                if (it.days?.contains(todayDate) == true) {
                    tasks.add(Task(it.id, it.name+" needs to be taken at "+it.time, it.isTaken == true))
                }
            }

            if(it.refill == true){
                if (it.pillsLeft < 3){
                    tasks.add(Task(it.id, it.name+" needs to be refilled", false))
                }
            }

        }
        return tasks
    }

}