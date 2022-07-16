package com.example.healthymindconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import org.w3c.dom.Text

class SpecialistOffers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.specialist_offers)
        populateOffer()

        val acceptButton : Button = findViewById(R.id.SpecialistAccept)

        acceptButton.setOnClickListener{
            acceptOffer()
            var intent = Intent(this, SpecialistHomePage::class.java)
            startActivity(intent)
        }

    }

    fun populateOffer(){
        val db = FirebaseFirestore.getInstance()

        val specialistTime : TextView = findViewById(R.id.SpecialistOfferTime)
        val specialistDay : TextView = findViewById(R.id.SpecialistOfferDay)
        val patientName : TextView = findViewById(R.id.SpecialistMeeting)

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

        db.collection("users")
            .get()
            .addOnCompleteListener {
                val result : StringBuffer = StringBuffer()

                if(it.isSuccessful) {
                    for(document in it.result!!){
                        patientName.setText(document.data.getValue("firstName").toString() +" " + document.data.getValue("lastName").toString())
                    }

                }
            }

    }

    fun acceptOffer(){
        val db = FirebaseFirestore.getInstance()
        var map = mutableMapOf<String,Any>()
        map["SpecialistAccepted"] = true

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