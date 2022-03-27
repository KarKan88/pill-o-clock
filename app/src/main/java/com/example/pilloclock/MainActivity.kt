package com.example.pilloclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLogInClick = findViewById<Button>(R.id.login)
        btnLogInClick.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            // start LoginActivity
            startActivity(intent)
        }
        val btnSignUpClick = findViewById<Button>(R.id.signup)
        btnSignUpClick.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            // start SignUpActivity
            startActivity(intent)
        }
    }
}