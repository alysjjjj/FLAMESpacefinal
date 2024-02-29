package com.example.flamespace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class Ptc : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        findViewById<View>(R.id.ptc_201).setOnClickListener(this)
        findViewById<View>(R.id.ptc_301).setOnClickListener(this)
        findViewById<View>(R.id.ptc_302).setOnClickListener(this)
        findViewById<View>(R.id.ptc_303).setOnClickListener(this)
        findViewById<View>(R.id.ptc_304).setOnClickListener(this)
        findViewById<View>(R.id.ptc_305).setOnClickListener(this)
        findViewById<View>(R.id.ptc_306).setOnClickListener(this)
        findViewById<View>(R.id.ptc_403).setOnClickListener(this)
        findViewById<View>(R.id.ptc_404).setOnClickListener(this)
        findViewById<View>(R.id.ptc_405).setOnClickListener(this)
        findViewById<View>(R.id.ptc_406).setOnClickListener(this)

        // Initialize backButton and set its onClickListener
        val backButton = findViewById<View>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onClick(v: View) {
        // Handle clicks for each room
        when (v.id) {
            R.id.ptc_201 -> handleRoomClick("Room 201")
            R.id.ptc_301 -> handleRoomClick("Room 301")
            R.id.ptc_302 -> handleRoomClick("Room 302")
            R.id.ptc_303 -> handleRoomClick("Room 303")
            R.id.ptc_304 -> handleRoomClick("Room 304")
            R.id.ptc_305 -> handleRoomClick("Room 305")
            R.id.ptc_306 -> handleRoomClick("Room 306")
            R.id.ptc_403 -> handleRoomClick("Room 403")
            R.id.ptc_404 -> handleRoomClick("Room 404")
            R.id.ptc_405 -> handleRoomClick("Room 405")
            R.id.ptc_406 -> handleRoomClick("Room 406")
        }
    }

    private fun handleRoomClick(roomName: String) {
        // Show a toast when a room is clicked
        Toast.makeText(this, "Clicked on $roomName", Toast.LENGTH_SHORT).show()
    }
}
