package com.example.healthymindconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class PatientMeetingOffers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.patient_meeting_offers)
        populateOffer()

        val accept : Button = findViewById(R.id.PatientAccept)

        accept.setOnClickListener {
            acceptOffer()
            var intent = Intent(this, PatientHomePage::class.java)
            startActivity(intent)

        }


    }

    fun populateOffer(){
        val db = FirebaseFirestore.getInstance()

        val specialistTime : TextView = findViewById(R.id.SpecialistOfferTime)
        val specialistDay : TextView = findViewById(R.id.SpecialistOfferDay)
        val SpecialistName : TextView = findViewById(R.id.patient_meeting)

        db.collection("Meetings")
            .get()
            .addOnCompleteListener {
                val result : StringBuffer = StringBuffer()

                if(it.isSuccessful) {
                    for(document in it.result!!){
                        specialistTime.setText(document.data.getValue("Time").toString())
                        specialistDay.setText(document.data.getValue("Date").toString())
                    }

                }
            }

        db.collection("Specialist")
            .get()
            .addOnCompleteListener {
                val result : StringBuffer = StringBuffer()

                if(it.isSuccessful) {
                    for(document in it.result!!){
                        SpecialistName.setText(document.data.getValue("firstName").toString() +" " + document.data.getValue("lastName").toString())
                    }

                }
            }

    }

    fun acceptOffer(){
        val db = FirebaseFirestore.getInstance()
        var map = mutableMapOf<String,Any>()
        map["PatientAccepted"] = true

        db.collection("Meetings")
            .get()
            .addOnCompleteListener {

                if(it.isSuccessful) {
                    for(document in it.result!!){
                        document.reference.update(map)
                    }

                }
            }

    }
}