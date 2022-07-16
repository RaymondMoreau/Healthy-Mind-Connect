package com.example.healthymindconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class BookMeeting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_meeting_page)


        val MeetingTime : EditText = findViewById(R.id.BookMeetingTime)
        val MeetingDate : EditText = findViewById(R.id.BookMeetingDay)

        val BookMeeting : Button = findViewById(R.id.BookMeetingFinal)

        BookMeeting.setOnClickListener{
            saveFireStore(MeetingDate.text.toString(),MeetingTime.text.toString())
            var intent = Intent(this, PatientHomePage::class.java)
            startActivity(intent)
        }
    }



    fun saveFireStore(Date : String,Time : String){
        var db = FirebaseFirestore.getInstance()
        val meeting: MutableMap<String,Any> = HashMap()

        meeting["Time"]= Time
        meeting["Date"] = Date
        meeting["userName"] = "Patient"
        meeting["PatientAccepted"] = false
        meeting["SpecialistAccepted"] = false

        db.collection("Meetings")
            .add(meeting)
    }
}