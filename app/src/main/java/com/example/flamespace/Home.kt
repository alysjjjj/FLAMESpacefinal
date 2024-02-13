package com.example.flamespace

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.flamespace.R.id.cite
import com.example.flamespace.R.id.profile
import com.example.flamespace.R.id.ptc

class Home : AppCompatActivity() {
    @SuppressLint( "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val button = findViewById<Button>(ptc)
        button.setOnClickListener {
            val intent = Intent(this, Ptc_room::class.java)
            startActivity(intent)
        }

        val btn = findViewById<ImageView>(profile)
        btn.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}