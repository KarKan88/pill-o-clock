package com.example.pilloclock

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import java.util.*

class EnterDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_details)

        var button = findViewById<Button>(R.id.nextButton)
        button.setOnClickListener {
            val intent = Intent(this, VerifyDetails::class.java)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickStartDatePicker(view: View) {
        var startDateButton = findViewById<Button>(R.id.startDateButton)
        startDateButton.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                val text = """$dayOfMonth-${monthOfYear + 1}-$year"""
                startDateButton.text = text
            }, year, month, day)
            dialog.show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickEndDatePicker(view: View) {
        var endDateButton = findViewById<Button>(R.id.endDateButton)
        endDateButton.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val dialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                val text = """$dayOfMonth-${monthOfYear + 1}-$year"""
                endDateButton.text = text
            }, year, month, day)
            dialog.show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickTimePicker(view: View) {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)

        val dialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener(function = {view, h, m ->
            val text = "h.toString() + \" : \" + m +\" : " })
            , hour, minute, false)

        dialog.show()
    }
}