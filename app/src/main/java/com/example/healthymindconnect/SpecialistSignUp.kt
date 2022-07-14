package com.example.healthymindconnect

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import com.google.firebase.firestore.FirebaseFirestore

class SpecialistSignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.specialist_signup_page)

        val SpecialistFinishSignUp : Button = findViewById(R.id.SpecialistFinishSignUp)

        val firstName : EditText = findViewById(R.id.SpecialistFirstNae)
        val lastName : EditText = findViewById(R.id.SpecialistLastName)
        val password : EditText = findViewById(R.id.SpecialistPassword)
        val userName : EditText = findViewById(R.id.SpecialistUsername)
        val Therapy : CheckBox = findViewById(R.id.TherapyBox)
        val PsychoTherapy : CheckBox = findViewById(R.id.PsychotherabyBox)
        val Counseling : CheckBox = findViewById(R.id.CounselingBox)
        val Psychiatry : CheckBox = findViewById(R.id.PsychiatryBox)
        val gender : Spinner = findViewById(R.id.PatientGender)

        SpecialistFinishSignUp.setOnClickListener{

            val userNamedb : String = userName.text.toString();
            val passworddb : String = password.text.toString()
            val lastNamedb : String = lastName.text.toString()
            val firstnamedb : String = firstName.text.toString()
            val genderdb : String = gender.selectedItem.toString();
            val Therapydb : Boolean = Therapy.isChecked
            val PsychoTherapydb : Boolean = PsychoTherapy.isChecked
            val Psychiatry : Boolean = Psychiatry.isChecked
            val Counseling : Boolean = Counseling.isChecked
            saveFireStore(userNamedb,passworddb,firstnamedb,lastNamedb,genderdb,Therapydb,PsychoTherapydb,Psychiatry,Counseling );


            var intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
    }
    fun saveFireStore(username:String, password:String,firstname:String,lastname:String,gender:String,Therapy : Boolean,psychoTherapy : Boolean,Psychiatry : Boolean,Counseling : Boolean){
        var db = FirebaseFirestore.getInstance()
        val user: MutableMap<String,Any> = HashMap()
        user["username"] = username
        user["password"] = password
        user["firstName"] = firstname
        user["lastName"] = lastname
        user["gender"] = gender
        user["therapy"] = Therapy
        user["psychotherapy"] = psychoTherapy
        user["psychiatry"] = Psychiatry
        user["Counseling"] = Counseling



        db.collection("Specialist")
            .add(user)
    }
}