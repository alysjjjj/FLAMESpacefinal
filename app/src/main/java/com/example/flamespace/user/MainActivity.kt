package com.example.flamespace.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.flamespace.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.mainLogin)
        buttonClick.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        val btn = findViewById<Button>(R.id.mainSignup)
        btn.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }

    }
}