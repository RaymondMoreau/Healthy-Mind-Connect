package com.example.healthymindconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        val loginpage2: Button = findViewById(R.id.loginPageButton2)
        val username: EditText = findViewById(R.id.loginUsername)
        val password: EditText = findViewById(R.id.loginPassword)
        loginpage2.setOnClickListener{
            val username = username.text.toString();
            var intent = Intent(this, PatientHomePage::class.java)
            if(username == "Specialist"){
                intent = Intent(this, SpecialistHomePage::class.java)
            }
            startActivity(intent)
        }
    }
}