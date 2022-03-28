package com.example.pilloclock

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class CalendarActivity : AppCompatActivity(), CalendarAdapter.OnItemListener {
    // Initialize Variables
    private var month: TextView? = null
    private var calendarRecyclerView: RecyclerView? = null

    companion object {
        var selectedDate: LocalDate? = null
        @RequiresApi(Build.VERSION_CODES.O)
        var cusor: LocalDate = LocalDate.now();
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        initWidgets()
        selectedDate = LocalDate.now()
        setMonthView()

        // Bottom Navigation Bar
        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav)

        // Set Selected
        bottomNavigation.setSelectedItemId(R.id.bottom_nav_item_calendar)

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

    // Set or update the month view on calendar
    @RequiresApi(Build.VERSION_CODES.O)
    private fun setMonthView() {
        month?.setText(selectedDate?.let { getMonth(it) })
        var days : ArrayList<String>? = selectedDate?.let { getDays(it) }
        var calendarAdapter : CalendarAdapter? = days?.let { CalendarAdapter(it, this) }
        var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext, 7)
        calendarRecyclerView?.layoutManager = layoutManager
        calendarRecyclerView?.adapter = calendarAdapter
    }

    // Returns a populated arraylist of dates in given month
    @RequiresApi(Build.VERSION_CODES.O)
    private fun getDays(date: LocalDate): ArrayList<String> {
        var days : ArrayList<String> = ArrayList()
        var yearMonth : YearMonth = YearMonth.from(date)

        var numDays = yearMonth.lengthOfMonth()

        var firstOfMonth : LocalDate? = selectedDate?.withDayOfMonth(1)
        var dayOfWeek = firstOfMonth?.dayOfWeek?.value

        for (i in 1..42){
            if (i <= dayOfWeek!! || i > numDays + dayOfWeek){
                days.add("")
            } else {
                days.add((i - dayOfWeek).toString())
            }
        }
        return days
    }

    // Returns the month of the given date
    @RequiresApi(Build.VERSION_CODES.O)
    private fun getMonth(date : LocalDate): String? {
        var formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMMM")
        return date.format(formatter)
    }

    // Initalize Calendar Pieces
    private fun initWidgets() {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView)
        month = findViewById(R.id.month)

    }

    // Change the current month to month + 1
    @RequiresApi(Build.VERSION_CODES.O)
    fun nextMonth(view: View) {
        selectedDate = selectedDate?.plusMonths(1)
        setMonthView()
    }

    // Change the current month to month - 1
    @RequiresApi(Build.VERSION_CODES.O)
    fun previousMonth(view: View) {
        selectedDate = selectedDate?.minusMonths(1)
        setMonthView()
    }

    // Change the currently displayed date to the one that is clicked along with medication details
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onItemClick(position: Int, day: String) {
        if(!day.equals("")){
            var dayInt = Integer.parseInt(day)
            var monthInt = selectedDate?.monthValue
            var select : LocalDate? = monthInt?.let { LocalDate.of(2021, it, dayInt) }

            if (select != null) {
                cusor = select
                setMonthView()
            }
        }
    }
}