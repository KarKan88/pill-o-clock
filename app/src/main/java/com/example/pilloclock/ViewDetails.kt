package com.example.pilloclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.pilloclock.data.entity.Pill

class ViewDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_details)

        val position = intent.getSerializableExtra("Position") as Int

        val pill = Pill(
            1, "Med 1", "Prozac", "10AM", "Mon, Tue, Wed", "blue_pill",
            "20/10/22", "22/11/22", "10Mg", 66.0, true, "27/03/22",
            "", "", ""
        )

        val pill2 = Pill(
            1, "Med 2", "Aspirin", "10AM", "Mon, Tue, Wed", "pink_pill",
            "20/10/22", "22/11/22", "10Mg", 66.0, false, "27/03/22",
            "", "", ""
        )

        val pillList = listOf(pill, pill2)

        val nameText = findViewById<TextView>(R.id.nameText)
        val brandText = findViewById<TextView>(R.id.brandText)
        val dosageText = findViewById<TextView>(R.id.dosageText)
        val startDateText = findViewById<TextView>(R.id.startDateText)
        val endDateText = findViewById<TextView>(R.id.endDateText)
        val refillText = findViewById<TextView>(R.id.refillText)
        val intakeText = findViewById<TextView>(R.id.intakeText)
        val icon = findViewById<ImageView>(R.id.iconImg)

        val currPill = pillList[position]
        nameText.text = currPill.name
        brandText.text = currPill.brand
        dosageText.text = currPill.dosage
        startDateText.text = currPill.startDate
        if (currPill.endDate != "") {
            endDateText.text = currPill.endDate
        }
        else {
            endDateText.text = currPill.pillsLeft.toString()
        }
        refillText.text = currPill.refill.toString()
        val intake = """${currPill.days} at ${currPill.time}"""
        intakeText.text = intake
        val uri = """drawable/${currPill.icon}"""
        val imageResource = resources.getIdentifier(uri, null, packageName)
        val res = resources.getDrawable(imageResource, null)
        icon.setImageDrawable(res)
    }

    fun clickEditButton(view: View) {
        
    }
}