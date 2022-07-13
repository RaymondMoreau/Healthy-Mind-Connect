package com.example.healthymindconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore

class PatientHomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.patient_home_page)

        val profileButton: Button = findViewById(R.id.ProfileButton)

        profileButton.setOnClickListener{
            var intent = Intent(this, PatientProfile::class.java)
            startActivity(intent)
        }

        val offerbutton : Button = findViewById(R.id.PatientMatchedMeetings)

        offerbutton.setOnClickListener {
            var intent = Intent(this, PatientMeetingOffers::class.java)
            startActivity(intent)
        }

        val BookMeeting : Button = findViewById(R.id.PatientBookMeeting)
        BookMeeting.setOnClickListener{
            saveFireStore()
            
        }


    }
    fun saveFireStore(){
        var db = FirebaseFirestore.getInstance()
        val meeting: MutableMap<String,Any> = HashMap()
        meeting["userName"] = "Patient"
        meeting["PatientAccepted"] = false
        meeting["SpecialistAccepted"] = false

        db.collection("Meetings")
            .add(meeting)
    }
}