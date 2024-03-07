package com.example.flamespace.buildings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.flamespace.R
import com.example.flamespace.user.Reservation


class Mba : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mba_room)


        val backButton: FrameLayout = findViewById(R.id.backButton)
        backButton.setOnClickListener { onBackPressed() }

        findViewById<CardView>(R.id.mba_307).setOnClickListener {
            showPopup("MBA 307", "40 chairs\n1 air conditioner working")
        }
        findViewById<CardView>(R.id.mba_308).setOnClickListener {
            showPopup("MBA 308", "50 chairs\nno air conditioner working")
        }

        findViewById<CardView>(R.id.mba_309).setOnClickListener {
            showPopup("MBA 309", "60 chairs\n3 air conditioner working")
        }

        findViewById<CardView>(R.id.mba_310).setOnClickListener {
            showPopup("MBA 310", "57 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.mba_405).setOnClickListener {
            showPopup("MBA 405", "44 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.mba_406).setOnClickListener {
            showPopup("MBA 406", "49 chairs\n2 air conditioner working")
        }
        findViewById<CardView>(R.id.mba_407).setOnClickListener {
            showPopup("MBA 407", "52 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.mba_504).setOnClickListener {
            showPopup("MBA 504", "50 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.mba_505).setOnClickListener {
            showPopup("MBA 505", "45 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.mba_506).setOnClickListener {
            showPopup("MBA 506", "55 chairs\n2 air conditioner working")
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

    override fun onClick(v: View?) {

    }
}
