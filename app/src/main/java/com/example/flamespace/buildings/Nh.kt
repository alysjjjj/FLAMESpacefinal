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

class Nh : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nh_room)


        val backButton: FrameLayout = findViewById(R.id.backButton)
        backButton.setOnClickListener { onBackPressed() }

        findViewById<CardView>(R.id.nh_111).setOnClickListener {
            showPopup("NH 111", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.nh_112).setOnClickListener {
            showPopup("NH 112", "50 chairs\nno air conditioner working")
        }

        findViewById<CardView>(R.id.nh_113).setOnClickListener {
            showPopup("NH 113", "60 chairs\n3 air conditioner working")
        }

        findViewById<CardView>(R.id.nh_114).setOnClickListener {
            showPopup("NH 114", "57 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.nh_115).setOnClickListener {
            showPopup("NH 115", "44 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.nh_116).setOnClickListener {
            showPopup("NH 116", "49 chairs\n2 air conditioner working")
        }
        findViewById<CardView>(R.id.nh_117).setOnClickListener {
            showPopup("NH 117", "52 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.nh_118).setOnClickListener {
            showPopup("NH 118", "50 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.nh_119).setOnClickListener {
            showPopup("NH 119", "45 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.nh_120).setOnClickListener {
            showPopup("NH 200", "55 chairs\n2 air conditioner working")
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