package com.example.pilloclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.pilloclock.data.AppDatabase
import com.example.pilloclock.data.entity.Pill

class EditDetails : AppCompatActivity() {
    var iconImage: ImageView? = null
    var nameEdit: EditText? = null
    var brandEdit: EditText? = null
    var dosageEdit: EditText? = null
    var startDateButton: Button? = null
    var endDateButton: Button? = null
    var refillCheckbox: CheckBox? = null
    var monRadioButton: RadioButton? = null
    var tueRadioButton: RadioButton? = null
    var wedRadioButton: RadioButton? = null
    var thuRadioButton: RadioButton? = null
    var friRadioButton: RadioButton? = null
    var satRadioButton: RadioButton? = null
    var sunRadioButton: RadioButton? = null
    var timeButton: Button? = null
    var notesEdit: EditText? = null
    var pillCountEdit: EditText? = null
    var spinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_details)
        val position = intent.getSerializableExtra("Position") as Int

        iconImage = findViewById(R.id.iconImg)
        nameEdit = findViewById(R.id.medicationNameEdit)
        brandEdit = findViewById(R.id.brandNameEdit)
        dosageEdit = findViewById(R.id.dosageEdit)
        startDateButton = findViewById(R.id.startDateButton)
        endDateButton = findViewById(R.id.endDateButton)
        refillCheckbox = findViewById(R.id.refillCheckBox)
        monRadioButton = findViewById(R.id.monRadioButton)
        tueRadioButton = findViewById(R.id.tueRadioButton)
        wedRadioButton = findViewById(R.id.wedRadioButton)
        thuRadioButton = findViewById(R.id.thuRadioButton)
        friRadioButton = findViewById(R.id.friRadioButton)
        satRadioButton = findViewById(R.id.satRadioButton)
        sunRadioButton = findViewById(R.id.sunRadioButton)
        timeButton = findViewById(R.id.timeButton)
        notesEdit = findViewById(R.id.notesEdit)
        pillCountEdit = findViewById(R.id.pillCountEdit)
        spinner = findViewById(R.id.spinner)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.Icons))
        spinner!!.adapter = adapter

        val pillDao = AppDatabase.getDatabase(this.application).pillDao()
        val pillList = pillDao.getAll()

        restoreValues(pillList[position])

        val deleteButton = findViewById<Button>(R.id.deleteButton)
        deleteButton.setOnClickListener {
            pillDao.delete(pillList[position])
            val intent = Intent(this, MedicationList::class.java)
            startActivity(intent)
        }

        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            pillDao.insertAll(pillList[position])
        }

        val cancelButton = findViewById<Button>(R.id.cancelButton)
        cancelButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun restoreValues(pill: Pill) {
        nameEdit!!.setText(pill.name)
        brandEdit!!.setText(pill.brand)
        dosageEdit!!.setText(pill.dosage)
        startDateButton!!.text = pill.startDate
        if(pill.endDate != "") {
            endDateButton!!.text = pill.endDate
        }
        if(pill.pillsLeft != 0.0) {
            pillCountEdit!!.setText(pill.pillsLeft.toString())
        }
        refillCheckbox!!.isChecked = pill.refill!!
        val intakeRadioButtons = arrayOf(monRadioButton, tueRadioButton, wedRadioButton, thuRadioButton, friRadioButton, satRadioButton, sunRadioButton)
        for(x in intakeRadioButtons) {
            if(x!!.text in pill.days!!) {
                x.isChecked = true
            }
        }
        timeButton!!.text = pill.time
        notesEdit!!.setText(pill.notes)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.Icons))
        spinner!!.adapter = adapter
        spinner!!.setSelection(adapter.getPosition(pill.icon))
    }
}