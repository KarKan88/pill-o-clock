package com.example.pilloclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.reflect.Type

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Initialize Variables
        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)

        // Set Selected
        bottomNavigation.setSelectedItemId(R.id.bottom_nav_item_home)

        // Perform Navigation to different activities
        bottomNavigation.setOnItemSelectedListener{
            when (it.itemId){
                R.id.bottom_nav_item_home -> navigateToActitity(DashboardActivity::class.java)
//                R.id.bottom_nav_item_calendar -> navigateToActitity(CalendarActivity::class.java)
//                R.id.bottom_nav_item_medications -> navigateToActitity(MedicationActivity::class.java)
//                R.id.bottom_nav_item_more -> navigateToActitity(MoreActivity::class.java)
            }
            true
        }
    }

    private fun navigateToActitity(java: Type) {
        TODO("Implement navigation")
    }
}