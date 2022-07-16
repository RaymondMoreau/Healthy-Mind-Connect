package com.example.healthymindconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class SpecialistHomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.specialist_home_page)

        val Profilebutton : Button = findViewById(R.id.SpecialistProfileButton2)
        Profilebutton.setOnClickListener{
            var intent = Intent(this,SpecialistProfilePage::class.java)
            startActivity(intent)
        }

        val offerPage : Button = findViewById(R.id.SpecialistHomeOffers)

        offerPage.setOnClickListener{
            var intent = Intent(this,SpecialistOffers::class.java)
            startActivity(intent)
        }

        val upcomingMeetings : Button = findViewById(R.id.SpecialistUpcoming)

        upcomingMeetings.setOnClickListener{
            var intent = Intent(this, UpcomingMeetings::class.java)
            startActivity(intent)
        }

    }





}