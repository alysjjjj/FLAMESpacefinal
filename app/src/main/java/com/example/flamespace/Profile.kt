package com.example.flamespace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.cardview.widget.CardView

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Find the main CardView
        val profileCardView = findViewById<CardView>(R.id.profile_cardview)

        // Find and set OnClickListener to the inner CardViews
        val editCardView = profileCardView.findViewById<CardView>(R.id.edit_cv)
        editCardView.setOnClickListener {
            val intent = Intent(this, Edit_profile::class.java)
            startActivity(intent)
        }

        val currentCardView = profileCardView.findViewById<CardView>(R.id.current_cv)
        currentCardView.setOnClickListener {
            val intent = Intent(this, Current::class.java)
            startActivity(intent)
        }

        val historyCardView = profileCardView.findViewById<CardView>(R.id.history_cv)
        historyCardView.setOnClickListener {
            val intent = Intent(this, History::class.java)
            startActivity(intent)
        }

        // Your existing code for backButton click goes here

        val backButton = findViewById<FrameLayout>(R.id.backButton)
        backButton.setOnClickListener {

            goBackToPreviousPage()
        }
    }

    private fun goBackToPreviousPage() {
        onBackPressed()
    }
}
