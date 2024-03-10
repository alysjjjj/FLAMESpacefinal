package com.example.flamespace.buildings

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.content.Context
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.flamespace.R
import com.example.flamespace.profile.Current
import com.example.flamespace.user.Reservation
import com.google.android.material.card.MaterialCardView


class Ptc : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val backButton = findViewById<android.widget.ImageView>(R.id.backButton)
        backButton.setOnClickListener {

            goBackToPreviousPage()
        }



        findViewById<CardView>(R.id.ptc_201).setOnClickListener {
            showPopup("PTC 201", "50 chairs\n1 air conditioner working")
        }

        findViewById<CardView>(R.id.ptc_301).setOnClickListener {
            showPopup("PTC 301", "45 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.ptc_302).setOnClickListener {
            showPopup("PTC 302", "60 chairs\n3 air conditioner working")
        }

        findViewById<CardView>(R.id.ptc_303).setOnClickListener {
            showPopup("PTC 303", "55 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.ptc_304).setOnClickListener {
            showPopup("PTC 304", "40 chairs\n1 air conditioner working")
        }

        findViewById<CardView>(R.id.ptc_305).setOnClickListener {
            showPopup("PTC 305", "48 chairs\n2 air conditioner working")
        }

        findViewById<CardView>(R.id.ptc_306).setOnClickListener {
            showPopup("PTC 306", "48 chairs\n2 air conditioner working")
        }
        findViewById<CardView>(R.id.ptc_403).setOnClickListener {
            showPopup("PTC 403", "48 chairs\n2 air conditioner working")
        }
        findViewById<CardView>(R.id.ptc_404).setOnClickListener {
            showPopup("PTC 404", "48 chairs\n2 air conditioner working")
        }
        findViewById<CardView>(R.id.ptc_405).setOnClickListener {
            showPopup("PTC 405", "48 chairs\n2 air conditioner working")
        }
        findViewById<CardView>(R.id.ptc_406).setOnClickListener {
            showPopup("PTC 406", "48 chairs\n2 air conditioner working")
        }



    }

    private fun navigateToReservationActivity(roomCode: String) {
        val intent = Intent(this, Reservation::class.java)
        intent.putExtra("ROOM_CODE", roomCode)
        startActivity(intent)
    }



    private fun goBackToPreviousPage() {
        onBackPressed()
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
            navigateToReservationActivity(roomCode)
            popupWindow.dismiss()
        }

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
    }

    override fun onClick(v: View?) {
    }
}
