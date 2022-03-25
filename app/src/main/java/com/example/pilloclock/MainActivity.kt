package com.example.pilloclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.pilloclock.data.AppDatabase
import com.example.pilloclock.data.dao.UserDao
import com.example.pilloclock.data.entity.User
import com.example.pilloclock.data.repo.UserRepository

class MainActivity : AppCompatActivity() {

    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, AddMedication::class.java)
            startActivity(intent)
        }

    }
}