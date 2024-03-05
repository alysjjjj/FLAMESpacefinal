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


class Mba : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mba_room)


        val backButton = findViewById<FrameLayout>(R.id.backButton)
        backButton.setOnClickListener {

            goBackToPreviousPage()
        }

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

        findViewById<CardView>(R.id.mba_311).setOnClickListener {
            showPopup("MBA 311", "44 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.mba_312).setOnClickListener {
            showPopup("MBA 312", "49 chairs\n2 air conditioner working")
        }
        findViewById<CardView>(R.id.mba_313).setOnClickListener {
            showPopup("MBA 313", "52 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.mba_314).setOnClickListener {
            showPopup("MBA 314", "50 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.mba_315).setOnClickListener {
            showPopup("MBA 315", "45 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.mba_316).setOnClickListener {
            showPopup("MBA 316", "55 chairs\n2 air conditioner working")
        }



    }
    private fun goBackToPreviousPage() {
        onBackPressed()
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

    override fun onClick(v: View?) {

    }
}
