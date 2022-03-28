package com.example.pilloclock

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.example.FDAMedicationResponse
import com.example.pilloclock.services.FDAMedicationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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
                    val BASE_URL = "https://api.fda.gov/"

                    val retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    val service = retrofit.create(FDAMedicationService::class.java)
                    val call = service.getMedicationDetails("5", "Advil")

                    call.enqueue(object : Callback<FDAMedicationResponse> {
                        override fun onResponse(call: Call<FDAMedicationResponse>, response: Response<FDAMedicationResponse>) {
                            if (response.code() == 200) {
                                val fdaMedicationResponse = response.body()!!
                                System.err.println(fdaMedicationResponse)
                            }
                        }

                        override fun onFailure(call: Call<FDAMedicationResponse>, t: Throwable) {
                            //TODO failure
                        }
                    })

                    val intent = Intent(this@LandingPageActivity, DashboardActivity::class.java)
                    startActivity(intent);
                }
            }
        )
    }
}