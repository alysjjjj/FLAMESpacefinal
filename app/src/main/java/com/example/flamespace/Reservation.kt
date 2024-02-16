package com.example.flamespace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView


class Reservation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val button = findViewById<ImageView>(R.id.btn1)
        button.setOnClickListener {
            val int = Intent(this, Ptc_room::class.java)
            startActivity(int)
        }
    }
}