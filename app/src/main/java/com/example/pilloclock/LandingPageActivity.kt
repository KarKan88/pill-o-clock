package com.example.pilloclock

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        var loginButton = findViewById<Button>(R.id.login_button)
        var signUpButton = findViewById<Button>(R.id.sign_up_button)
        var skipButton = findViewById<Button>(R.id.skip_button)

        loginButton.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val intent = Intent(this@LandingPageActivity, LoginActivity::class.java)
                    startActivity(intent);
                }
            }
        )

        signUpButton.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val intent = Intent(this@LandingPageActivity, SignUpActivity::class.java)
                    startActivity(intent);
                }
            }
        )

        skipButton.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val intent = Intent(this@LandingPageActivity, DashboardActivity::class.java)
                    startActivity(intent);
                }
            }
        )
    }
}