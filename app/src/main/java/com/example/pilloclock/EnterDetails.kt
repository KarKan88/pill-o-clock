package com.example.pilloclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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
}