package com.example.healthymindconnect

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PatientMeetingOffers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.patient_meeting_offers)

        val acceptButton : Button = findViewById(R.id.PatientAccept)
        acceptButton.setOnClickListener{

        }


    }

}