package com.example.flamespace


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class Current : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current)


        val backButton = findViewById<FrameLayout>(R.id.backButton)
        backButton.setOnClickListener {

            goBackToPreviousPage()
        }


    }
    private fun goBackToPreviousPage() {
        onBackPressed()
    }
}