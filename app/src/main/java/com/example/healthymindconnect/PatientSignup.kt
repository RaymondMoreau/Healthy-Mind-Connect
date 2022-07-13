package com.example.healthymindconnect

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class PatientSignup : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.patient_signup_page)


        val firstName : EditText = findViewById(R.id.PatientFirstName)
        val lastName : EditText = findViewById(R.id.PatientLastname)
        val gender : Spinner = findViewById(R.id.SpecialistGender)
        val userName : EditText = findViewById(R.id.SpecialistUsername)
        val password : EditText = findViewById(R.id.SpecialistPassword)
        val meds : EditText = findViewById(R.id.PatientCurrentMed)
        val patientSignup: Button = findViewById(R.id.PatientSignUp)



        gender.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                val item = parent.getItemAtPosition(pos)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        patientSignup.setOnClickListener{
            val userNamedb : String = userName.text.toString();
            val passworddb : String = password.text.toString()
            val lastNamedb : String = lastName.text.toString()
            val firstnamedb : String = firstName.text.toString()
            val meddb : String = meds.text.toString()
            val genderdb : String = gender.selectedItem.toString();

            saveFireStore(userNamedb,passworddb,firstnamedb,lastNamedb,genderdb,meddb);


            var intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
    }

    fun saveFireStore(username:String, password:String,firstname:String,lastname:String,gender:String,meds:String){
        var db = FirebaseFirestore.getInstance()
        val user: MutableMap<String,Any> = HashMap()
        user["username"] = username
        user["password"] = password
        user["firstName"] = firstname
        user["lastName"] = lastname
        user["gender"] = gender
        user["medication"] = meds

        db.collection("users")
            .add(user)
    }
}