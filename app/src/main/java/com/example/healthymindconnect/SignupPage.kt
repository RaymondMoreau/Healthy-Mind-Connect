package com.example.healthymindconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignupPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page)

        val notSpecialist: Button = findViewById(R.id.NoSpecialist)

        notSpecialist.setOnClickListener{
            var intent = Intent(this, PatientSignup::class.java)
            startActivity(intent)
        }
    }

}