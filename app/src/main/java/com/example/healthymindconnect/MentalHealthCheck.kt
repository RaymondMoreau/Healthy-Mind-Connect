package com.example.healthymindconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class MentalHealthCheck : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mental_health_check)


        val completeCheck : Button = findViewById(R.id.CompleteSurvey)

        completeCheck.setOnClickListener{
            updateFireStore()
            var intent = Intent(this,PatientHomePage::class.java)
            startActivity(intent)
        }



    }

    fun updateFireStore(){
        val db = FirebaseFirestore.getInstance()
        var map = mutableMapOf<String,Any>()
        map["mentalHealthCheck"] = true

        db.collection("users")
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
