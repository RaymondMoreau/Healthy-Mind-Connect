package com.example.healthymindconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class SpecialistProfilePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.specialist_profile_page)
        checkBoxes()

        val HomeButton : Button = findViewById(R.id.SpecialistHome)
        HomeButton.setOnClickListener{
            var intent = Intent(this,SpecialistHomePage::class.java)
            startActivity(intent)
        }




    }


    fun checkBoxes(){
        var db = FirebaseFirestore.getInstance()

        val therapyBox : CheckBox = findViewById(R.id.therapyBoxpfpp)
        val Psychiatry : CheckBox = findViewById(R.id.psychiatryBoxpfp)
        val PsychoTherapy : CheckBox = findViewById(R.id.psychotherabyBoxpfp)
        val Counseling : CheckBox = findViewById(R.id.counselingBoxpfp)

        val fname : TextView = findViewById(R.id.SpecialistFirst)
        val lname :TextView = findViewById(R.id.SpecialistLast)

        db.collection("Specialist")
            .get()
            .addOnCompleteListener {
                val result : StringBuffer = StringBuffer()

                if(it.isSuccessful) {
                    for(document in it.result!!){
                        if(document.data.getValue("Counseling") == true){
                            Counseling.isChecked = true
                        }
                        if(document.data.getValue("therapy") == true){
                            therapyBox.isChecked = true
                        }
                        if(document.data.getValue("psychotherapy") == true){
                            PsychoTherapy.isChecked = true
                        }
                        if(document.data.getValue("psychiatry") == true){
                            Psychiatry.isChecked = true
                        }
                        fname.setText(document.data.getValue("firstName").toString())
                        lname.setText(document.data.getValue("lastName").toString())
                    }

                }
            }


    }


}