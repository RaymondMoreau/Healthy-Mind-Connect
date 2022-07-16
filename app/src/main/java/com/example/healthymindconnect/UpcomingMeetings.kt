package com.example.healthymindconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.firebase.firestore.FirebaseFirestore

class UpcomingMeetings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upcoming_meetings)
        populateMeeting()

    }

    fun populateMeeting() {
        val db = FirebaseFirestore.getInstance()

        val Time: TextView = findViewById(R.id.UpcomingOfferTime)
        val Day: TextView = findViewById(R.id.UpcomingOfferDay)
        val linkButton : Button = findViewById(R.id.GetLink)


        db.collection("Meetings")
            .get()
            .addOnCompleteListener {
                val result: StringBuffer = StringBuffer()

                if (it.isSuccessful) {
                    for (document in it.result!!) {
                        if(document.data.getValue("PatientAccepted")==true && document.data.getValue("SpecialistAccepted")==true){
                            Time.setText(document.data.getValue("Time").toString())
                            Day.setText(document.data.getValue("Date").toString())
                            linkButton.isVisible = true
                        }
                    }

                }
            }


    }
}