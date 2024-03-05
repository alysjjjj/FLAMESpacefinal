package com.example.flamespace

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Cma : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cma_room)

        val buttonClick = findViewById<FrameLayout>(R.id.backButton)
        buttonClick.setOnClickListener {
            val int = Intent(this, Home::class.java)
            startActivity(int)
        }

        findViewById<CardView>(R.id.cma_123).setOnClickListener {
            showPopup("CMA 123", "40 chairs\n1 air conditioner working")
        }

        findViewById<CardView>(R.id.cma_124).setOnClickListener {
            showPopup("CMA 124", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_125).setOnClickListener {
            showPopup("CMA 125", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_126).setOnClickListener {
            showPopup("CMA 126", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_127).setOnClickListener {
            showPopup("CMA 127", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_128).setOnClickListener {
            showPopup("CMA 128", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_129).setOnClickListener {
            showPopup("CMA 129", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_200).setOnClickListener {
            showPopup("CMA 200", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_201).setOnClickListener {
            showPopup("CMA 201", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_202).setOnClickListener {
            showPopup("CMA 202", "40 chairs\n1 air conditioner working")
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
