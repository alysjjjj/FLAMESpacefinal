package com.example.flamespace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Cma : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cma_room)

        val backButton = findViewById<View>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }

    }
}