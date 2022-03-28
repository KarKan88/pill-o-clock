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

                R.id.bottom_nav_item_calendar -> {
                    val intent = Intent(this, CalendarActivity::class.java)
                    startActivity(intent);
                }

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
    }
}