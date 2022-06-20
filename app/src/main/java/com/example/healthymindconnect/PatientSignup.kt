package com.example.healthymindconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PatientSignup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.patient_signup_page)

        val patientSignup: Button = findViewById(R.id.PatientSignUp)

        patientSignup.setOnClickListener{
            var intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
    }
}