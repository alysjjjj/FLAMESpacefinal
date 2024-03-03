package com.example.flamespace

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class Mba : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mba_room)

        val buttonClick = findViewById<FrameLayout>(R.id.backButton)
        buttonClick.setOnClickListener {
            val int = Intent(this, Home::class.java)
            startActivity(int)
        }
    }
}