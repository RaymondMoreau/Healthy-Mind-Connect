package com.example.healthymindconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PatientProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.patient_profile_page)

        val profileButton: Button = findViewById(R.id.patientHome)

        profileButton.setOnClickListener{
            var intent = Intent(this, PatientHomePage::class.java)
            startActivity(intent)
        }
    }
}