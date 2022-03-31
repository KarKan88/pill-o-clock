package com.example.pilloclock

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.pilloclock.adapter.TaskListViewAdapter
import com.example.pilloclock.services.TaskService
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Initialize Variables
        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)

        // Bottom Navigation Bar
        // Set Selected
        bottomNavigation.setSelectedItemId(R.id.bottom_nav_item_home)

        // Perform Navigation to different activities
        bottomNavigation.setOnItemSelectedListener{
            when (it.itemId){
                R.id.bottom_nav_item_home -> {
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent);
                }
//                R.id.bottom_nav_item_calendar -> {
//                    val intent = Intent(this, CalendarActivity::class.java)
//                    startActivity(intent);
                R.id.bottom_nav_item_medications -> {
                    val intent = Intent(this, MedicationList::class.java)
                    startActivity(intent);
                }
//                R.id.bottom_nav_item_more -> {
//                    val intent = Intent(this, MoreActivity::class.java)
//                   startActivity(intent);
            }
            true
        }

        val taskService = TaskService(this.applicationContext)
        val cal: Calendar = Calendar.getInstance()
        cal.add(Calendar.DATE, 1)
        val format1 = SimpleDateFormat("dd-MM-yyyy")
        val formatted: String = format1.format(cal.time)

        val listView = findViewById<ListView>(R.id.taskView)
        val myListAdapter = TaskListViewAdapter(this,taskService.getTaskList(formatted))
        listView.adapter = myListAdapter
    }

    private fun navigateToActitity(java: Type) {
        TODO("Implement navigation")
    }
}