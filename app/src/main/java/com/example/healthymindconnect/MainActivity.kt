package com.example.healthymindconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.internal.ContextUtils.getActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signup: Button = findViewById(R.id.SignupPageButton)

        signup.setOnClickListener{
            val intent = Intent(this, SignupPage::class.java)
            startActivity(intent)

        }

        val login: Button = findViewById(R.id.loginPageButton)

        login.setOnClickListener{
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)

        }
    }

}