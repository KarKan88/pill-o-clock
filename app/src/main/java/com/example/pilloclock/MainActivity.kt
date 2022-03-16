package com.example.pilloclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val userDao = AppDatabase.getDatabase(this.application).userDao()
        userRepository = UserRepository(userDao)
        userRepository.addUser(User(1,"Kannan","Nanthakumar","kk@gmail.com","password",3,2,""))

        val textView1 = findViewById<TextView>(R.id.test123)
        textView1.setText(userRepository.getUser().toString())

    }
}