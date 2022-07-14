package com.example.healthymindconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class PatientProfile : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.patient_profile_page)
        readFireStoreData()

        val profileButton: Button = findViewById(R.id.patientHome)

        profileButton.setOnClickListener{
            var intent = Intent(this, PatientHomePage::class.java)
            startActivity(intent)
        }
    }

    fun readFireStoreData() {
        val db = FirebaseFirestore.getInstance()

        val pFirst : EditText = findViewById(R.id.PatientFirst)
        val pFirst2 : TextView = findViewById(R.id.FirstPP)
        val pLast :EditText = findViewById(R.id.PatientLast)
        val pLast2 : TextView = findViewById(R.id.LastPP)
        val gender : EditText = findViewById(R.id.PatientGenderPP)
        val username : EditText = findViewById(R.id.PatientUserPP)
        val password : EditText = findViewById(R.id.PatientPasswordPP)
        val meds : TextView = findViewById(R.id.PatientCurrentMedsPP)

        db.collection("users")
            .get()
            .addOnCompleteListener {
                val result : StringBuffer = StringBuffer()

                if(it.isSuccessful) {
                    for(document in it.result!!){
                        pFirst.setText(document.data.getValue("firstName").toString())
                        pFirst2.setText(document.data.getValue("firstName").toString())
                        pLast.setText(document.data.getValue("lastName").toString())
                        pLast2.setText(document.data.getValue("lastName").toString())
                        gender.setText(document.data.getValue("gender").toString())
                        username.setText(document.data.getValue("username").toString())
                        password.setText(document.data.getValue("password").toString())
                        meds.setText((document.data.getValue("medication").toString()))
                    }

                }
            }
    }
}