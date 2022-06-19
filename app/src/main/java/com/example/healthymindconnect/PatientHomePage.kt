package com.example.healthymindconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PatientHomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.patient_home_page)

        val profileButton: Button = findViewById(R.id.ProfileButton)

        profileButton.setOnClickListener{
            var intent = Intent(this, PatientProfile::class.java)
            startActivity(intent)
        }
    }
}