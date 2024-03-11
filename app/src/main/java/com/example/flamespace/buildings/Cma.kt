package com.example.flamespace.buildings

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.flamespace.R
import com.example.flamespace.user.Reservation

class Cma : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cma_room)

        val backButton: FrameLayout = findViewById(R.id.backButton)
        backButton.setOnClickListener { onBackPressed() }

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
        findViewById<CardView>(R.id.cma_323).setOnClickListener {
            showPopup("CMA 323", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_324).setOnClickListener {
            showPopup("CMA 324", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_324).setOnClickListener {
            showPopup("CMA 324", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_325).setOnClickListener {
            showPopup("CMA 325", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_326).setOnClickListener {
            showPopup("CMA 326", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.cma_327).setOnClickListener {
            showPopup("CMA 327", "40 chairs\n1 air conditioner working")
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
        val reserveButton = popupView.findViewById<android.widget.Button>(R.id.reserveButton)
        val btnCancel = popupView.findViewById<android.widget.Button>(R.id.cancelButton)

        roomCodeTextView.text = roomCode
        roomDetailsTextView.text = roomDetails

        reserveButton.setOnClickListener {
            navigateToReservationActivity(roomCode)
            popupWindow.dismiss()
        }

        btnCancel.setOnClickListener {
            popupWindow.dismiss()
        }

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
    }

}
