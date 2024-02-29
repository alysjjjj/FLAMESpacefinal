package com.example.flamespace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Be : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_be)

        val backButton = findViewById<View>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }


    }
}