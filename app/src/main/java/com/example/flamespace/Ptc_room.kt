package com.example.flamespace


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.flamespace.R.id.btn1
import com.example.flamespace.R.id.imageView5

class Ptc_room : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val buttonClick = findViewById<ImageView>(btn1)
        buttonClick.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val button = findViewById<ImageView>(imageView5)
        button.setOnClickListener {
            val intent = Intent(this, Reservation::class.java)
            startActivity(intent)
        }
    }
}