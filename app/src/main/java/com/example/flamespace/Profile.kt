package com.example.flamespace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.flamespace.R.id.backButton
import com.example.flamespace.R.id.edit

class Profile : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val buttonClick = findViewById<ImageView>(backButton)
        buttonClick.setOnClickListener {
            val int = Intent(this, Home::class.java)
            startActivity(int)
        }

        val btn = findViewById<ImageView>(edit)
        btn.setOnClickListener {
            val intent = Intent(this, Edit_profile::class.java)
            startActivity(intent)
        }

    }
}