package com.example.flamespace

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.flamespace.R.id.btn1
import com.example.flamespace.R.id.currentbtn
import com.example.flamespace.R.id.setting

class Profile : AppCompatActivity() {

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val buttonClick = findViewById<ImageView>(btn1)
        buttonClick.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val btn = findViewById<ImageView>(setting)
        btn.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }

        val btnn = findViewById<ImageView>(currentbtn)
        btnn.setOnClickListener {
            val intent = Intent(this, Current::class.java)
            startActivity(intent)
        }
    }
}