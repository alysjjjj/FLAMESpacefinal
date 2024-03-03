package com.example.flamespace

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.flamespace.R.id.be
import com.example.flamespace.R.id.cahs
import com.example.flamespace.R.id.cite
import com.example.flamespace.R.id.cma
import com.example.flamespace.R.id.mba
import com.example.flamespace.R.id.nh
import com.example.flamespace.R.id.profile

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val button = findViewById<ImageView>(cite)
        button.setOnClickListener {
            val int = Intent(this, Ptc::class.java)
            startActivity(int)
        }

        val btn = findViewById<ImageView>(profile)
        btn.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        val btn2 = findViewById<ImageView>(cma)
        btn2.setOnClickListener {
            val int = Intent(this, Cma::class.java)
            startActivity(int)
        }

        val btn3 = findViewById<ImageView>(mba)
        btn3.setOnClickListener {
            val int = Intent(this, Mba::class.java)
            startActivity(int)
        }

        val btn4 = findViewById<ImageView>(nh)
        btn4.setOnClickListener {
            val int = Intent(this, Nh::class.java)
            startActivity(int)
        }

        val btn5 = findViewById<ImageView>(cahs)
        btn5.setOnClickListener {
            val int = Intent(this, Cahs::class.java)
            startActivity(int)
        }

        val btn6 = findViewById<ImageView>(be)
        btn6.setOnClickListener {
            val int = Intent(this, Be::class.java)
            startActivity(int)
        }


    }

    class Cma : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_cma_room)

            val backButton = findViewById<ImageView>(R.id.backButton)
            backButton.setOnClickListener {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }

            val cma323CardView = findViewById<CardView>(R.id.cma_323)
            val cma324CardView = findViewById<CardView>(R.id.cma_324)

            cma323CardView.setOnClickListener {
                showPopup("PTC 201", "50 chairs\n1 aircon working")
            }

            cma324CardView.setOnClickListener {
                showPopup("PTC 202", "45 chairs\n2 air conditioners working")
            }
        }

        private fun showPopup(roomCode: String, roomDetails: String) {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.fragment_modal_popup, null)

            val width = LinearLayout.LayoutParams.MATCH_PARENT
            val height = LinearLayout.LayoutParams.WRAP_CONTENT
            val focusable = true

            val popupWindow = PopupWindow(popupView, width, height, focusable)

            val closeButton = popupView.findViewById<ImageView>(R.id.closeButton)
            val roomCodeTextView = popupView.findViewById<TextView>(R.id.roomCodeTextView)
            val roomDetailsTextView = popupView.findViewById<TextView>(R.id.roomDetailsTextView)
            val reserveButton = popupView.findViewById<Button>(R.id.reserveButton)

            roomCodeTextView.text = roomCode
            roomDetailsTextView.text = roomDetails

            closeButton.setOnClickListener {
                popupWindow.dismiss()
            }

            reserveButton.setOnClickListener {
                // Add your reservation logic here
                Toast.makeText(this, "Room reserved!", Toast.LENGTH_SHORT).show()
                popupWindow.dismiss()
            }

            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        }
    }

}

