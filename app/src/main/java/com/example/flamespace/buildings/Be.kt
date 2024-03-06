package com.example.flamespace.buildings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.flamespace.profile.Current
import com.example.flamespace.R

class Be : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_be)

        val backButton: FrameLayout = findViewById(R.id.backButton)
        backButton.setOnClickListener { onBackPressed() }

        findViewById<CardView>(R.id.be_121).setOnClickListener {
            showPopup("BE 123", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.be_122).setOnClickListener {
            showPopup("BE 124", "50 chairs\nno air conditioner working")
        }

        findViewById<CardView>(R.id.be_123).setOnClickListener {
            showPopup("BE 125", "60 chairs\n3 air conditioner working")
        }

        findViewById<CardView>(R.id.be_124).setOnClickListener {
            showPopup("BE 126", "57 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.be_221).setOnClickListener {
            showPopup("BE 127", "44 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.be_222).setOnClickListener {
            showPopup("BE 128", "49 chairs\n2 air conditioner working")
        }
        findViewById<CardView>(R.id.be_223).setOnClickListener {
            showPopup("BE 129", "52 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.be_224).setOnClickListener {
            showPopup("BE 130", "50 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.be_321).setOnClickListener {
            showPopup("BE 131", "45 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.be_322).setOnClickListener {
            showPopup("BE 132", "55 chairs\n2 air conditioner working")
        }


    }

    private fun navigateToReservationActivity(roomCode: String) {
        val intent = Intent(this, Reservation::class.java)
        intent.putExtra("ROOM_CODE", roomCode)
        startActivity(intent)
    }

    private fun showPopup(roomCode: String, roomDetails: String) {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.fragment_modal_popup, null)

        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT
        val focusable = true

        val popupWindow = PopupWindow(popupView, width, height, focusable)

        val roomCodeTextView = popupView.findViewById<android.widget.TextView>(R.id.roomCodeTextView)
        val roomDetailsTextView = popupView.findViewById<android.widget.TextView>(R.id.roomDetailsTextView)
        val reserveButton = popupView.findViewById<android.widget.Button>(R.id.reserveButton)

        roomCodeTextView.text = roomCode
        roomDetailsTextView.text = roomDetails

        reserveButton.setOnClickListener {
            val intent = Intent(this, Current::class.java)
            startActivity(intent)
            Toast.makeText(this, "Room reserved!", Toast.LENGTH_SHORT).show()
            popupWindow.dismiss()
        }

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
    }
}