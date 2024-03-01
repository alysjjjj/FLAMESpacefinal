package com.example.flamespace

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Ptc : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        // Set click listeners for each room CardView
        findViewById<CardView>(R.id.ptc_201).setOnClickListener {
            navigateToReservationActivity("PTC 201")
        }

        findViewById<CardView>(R.id.ptc_301).setOnClickListener {
            navigateToReservationActivity("PTC 301")
        }

        findViewById<CardView>(R.id.ptc_302).setOnClickListener {
            navigateToReservationActivity("PTC 302")
        }

        findViewById<CardView>(R.id.ptc_303).setOnClickListener {
            navigateToReservationActivity("PTC 303")
        }

        findViewById<CardView>(R.id.ptc_304).setOnClickListener {
            navigateToReservationActivity("PTC 304")
        }

        findViewById<CardView>(R.id.ptc_305).setOnClickListener {
            navigateToReservationActivity("PTC 305")
        }

        findViewById<CardView>(R.id.ptc_306).setOnClickListener {
            navigateToReservationActivity("PTC 306")
        }

        findViewById<CardView>(R.id.ptc_403).setOnClickListener {
            navigateToReservationActivity("PTC 403")
        }
        findViewById<CardView>(R.id.ptc_404).setOnClickListener {
            navigateToReservationActivity("PTC 404")
        }
        findViewById<CardView>(R.id.ptc_405).setOnClickListener {
            navigateToReservationActivity("PTC 405")
        }
        findViewById<CardView>(R.id.ptc_406).setOnClickListener {
            navigateToReservationActivity("PTC 406")
        }
    }

    override fun onClick(v: View?) {
        // Handle click events here if needed
    }

    private fun navigateToReservationActivity(roomCode: String) {
        val intent = Intent(this, Reservation::class.java)
        intent.putExtra("ROOM_CODE", roomCode)
        startActivity(intent)
    }
}
