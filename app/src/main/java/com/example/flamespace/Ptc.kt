package com.example.flamespace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Ptc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val button = findViewById<ImageView>(R.id.ptc_201_pic)
        button.setOnClickListener {
            val int = Intent(this, Reservation::class.java)
            startActivity(int)
        }



    }
}