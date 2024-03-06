package com.example.flamespace.buildings


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.flamespace.profile.Current
import com.example.flamespace.R

class Cahs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cahs_rooms)

        val backButton: FrameLayout = findViewById(R.id.backButton)
        backButton.setOnClickListener { onBackPressed() }

        findViewById<CardView>(R.id.cahs_123).setOnClickListener {
            showPopup("CAHS 123", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cahs_124).setOnClickListener {
            showPopup("CAHS 124", "50 chairs\n2 air conditioner working")
        }
        findViewById<CardView>(R.id.cahs_125).setOnClickListener {
            showPopup("CAHS 125", "53 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cahs_223).setOnClickListener {
            showPopup("CAHS 126", "56 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cahs_224).setOnClickListener {
            showPopup("CAHS 127", "40 chairs\n2 air conditioner working")
        }
        findViewById<CardView>(R.id.cahs_225).setOnClickListener {
            showPopup("CAHS 128", "60 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cahs_323).setOnClickListener {
            showPopup("CAHS 129", "39 chairs\n2 air conditioner working")
        }
        findViewById<CardView>(R.id.cahs_324).setOnClickListener {
            showPopup("CAHS 130", "49 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cahs_325).setOnClickListener {
            showPopup("CAHS 131", "55 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cahs_326).setOnClickListener {
            showPopup("CAHS 132", "50 chairs\n2 air conditioner working")
        }

    }

    private fun navigateToReservationActivity(roomCode: String) {
        val intent = Intent(this, Reservation::class.java)
        intent.putExtra("ROOM_CODE", roomCode)
        startActivity(intent)
    }
    private fun showPopup(roomCode: String, roomDetails: String) {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.fragment_modal_popup, null)

        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT
        val focusable = true

        val popupWindow = PopupWindow(popupView, width, height, focusable)

        val roomCodeTextView = popupView.findViewById<android.widget.TextView>(R.id.roomCodeTextView)
        val roomDetailsTextView = popupView.findViewById<android.widget.TextView>(R.id.roomDetailsTextView)
        val reserveButton = popupView.findViewById<Button>(R.id.reserveButton)

        roomCodeTextView.text = roomCode
        roomDetailsTextView.text = roomDetails

        reserveButton.setOnClickListener {
            navigateToReservationActivity(roomCode) // Pass room code to the reservation activity
            popupWindow.dismiss()
        }

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
    }

}