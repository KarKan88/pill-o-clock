package com.example.pilloclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.pilloclock.data.AppDatabase
import com.example.pilloclock.data.entity.Pill
import com.example.pilloclock.data.repo.PillRepository
import java.util.*

class VerifyDetails : AppCompatActivity() {
    var pillModel: PillModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_details)
        pillModel = intent.getSerializableExtra("Pill") as PillModel?

        val nameText = findViewById<TextView>(R.id.nameText)
        val brandText = findViewById<TextView>(R.id.brandText)
        val dosageText = findViewById<TextView>(R.id.dosageText)
        val startDateText = findViewById<TextView>(R.id.startDateText)
        val endDateText = findViewById<TextView>(R.id.endDateText)
        val refillText = findViewById<TextView>(R.id.refillText)
        val intakeText = findViewById<TextView>(R.id.intakeText)
        val icon = findViewById<ImageView>(R.id.iconImg)

        val uri = """drawable/${pillModel!!.icon}"""
        val imageResource = resources.getIdentifier(uri, null, packageName)
        val res = resources.getDrawable(imageResource, null)
        icon.setImageDrawable(res)
        nameText.text = pillModel!!.name
        brandText.text = pillModel!!.brand
        dosageText.text = pillModel!!.dosage
        startDateText.text = pillModel!!.startDate
        if (pillModel!!.endDate != "") {
            endDateText.text = pillModel!!.endDate
        }
        else {
            endDateText.text = pillModel!!.pillsLeft.toString()
        }
        if(pillModel!!.refillDate != "") {
            val text = "True"
            refillText.text = text
        }
        val intake = """${pillModel!!.days} at ${pillModel!!.time}"""
        intakeText.text = intake
    }

    fun clickEdit(view: View) {
        val intent = Intent(this, EnterDetails::class.java)
        intent.putExtra("Pill", pillModel)
        startActivity(intent)
    }

    fun clickSubmit(view: View) {
        val pillDao = AppDatabase.getDatabase(this.application).pillDao()
        val size = pillDao.getAll().size
        val pillEntity = Pill(size+1, pillModel!!.name, pillModel!!.brand, pillModel!!.time, pillModel!!.days, pillModel!!.icon, pillModel!!.startDate, pillModel!!.endDate, pillModel!!.dosage, pillModel!!.pillsLeft, pillModel!!.addedDate, pillModel!!.description, pillModel!!.notes, pillModel!!.doctor)
        val pillRepository = PillRepository(pillDao)
        pillRepository.addPill(pillEntity)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}