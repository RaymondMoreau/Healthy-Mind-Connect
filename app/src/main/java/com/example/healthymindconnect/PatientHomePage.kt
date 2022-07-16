package com.example.healthymindconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

        val mentalHealthCheck : Button = findViewById(R.id.mentalHealthCheck)

        mentalHealthCheck.setOnClickListener{
            var intent = Intent(this, MentalHealthCheck::class.java)
            startActivity(intent)
        }

        val offerbutton : Button = findViewById(R.id.PatientMatchedMeetings)

        offerbutton.setOnClickListener {
            var intent = Intent(this, PatientMeetingOffers::class.java)
            startActivity(intent)
        }

        val BookMeetingg : Button = findViewById(R.id.PatientBookMeeting)
        BookMeetingg.setOnClickListener{
            mentalHealthCheck()

        }

        val upcoming : Button = findViewById(R.id.PatientUpcoming)

        upcoming.setOnClickListener{
            var intent = Intent(this, UpcomingMeetings::class.java)
            startActivity(intent)
        }


    }

    fun mentalHealthCheck() {
        val db = FirebaseFirestore.getInstance()
        var intent = Intent(this,BookMeeting::class.java)

        db.collection("users")
            .get()
            .addOnCompleteListener {
                val result : StringBuffer = StringBuffer()

                if(it.isSuccessful) {
                    for(document in it.result!!){
                        if(document.data.getValue("mentalHealthCheck")==false){
                            intent = Intent(this,MentalHealthCheck::class.java)
                            startActivity(intent)
                        }
                        else{
                            startActivity(intent)
                        }
                    }

                }
            }
    }

}