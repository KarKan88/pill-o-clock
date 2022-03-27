package com.example.pilloclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddMedication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_medication)

        var button = findViewById<Button>(R.id.btnManual)
        button.setOnClickListener {
            val intent = Intent(this, EnterDetails::class.java)
            startActivity(intent)
        }
    }
}