package com.example.flamespace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Cahs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cahs_rooms)

        val backButton = findViewById<View>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }


    }
}