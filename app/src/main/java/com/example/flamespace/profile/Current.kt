package com.example.flamespace.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import com.example.flamespace.R

class Current : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current)

        val backButton: FrameLayout = findViewById(R.id.backButton)
        backButton.setOnClickListener { onBackPressed() }

        val roomCode = intent.getStringExtra("ROOM_CODE")
        val selectedTime = intent.getStringExtra("SELECTED_TIME")
        val subject = intent.getStringExtra("SUBJECT")


        val roomCodeTextView = findViewById<TextView>(R.id.current_room)
        if (!roomCode.isNullOrEmpty()) {
            roomCodeTextView.text = roomCode
        }

        val timeTextView = findViewById<TextView>(R.id.current_schedule)
        if (!selectedTime.isNullOrEmpty()) {
            timeTextView.text = selectedTime
        }

        val subjectTextView = findViewById<TextView>(R.id.current_subject)
        if (!subject.isNullOrEmpty()) {
            subjectTextView.text = subject
        }

        displayRoomDetails(roomCode ?: "PTC 201 ")

    }

    private fun displayRoomDetails(roomCode: String) {

        val roomCodeTextView = findViewById<TextView>(R.id.current_room)

        roomCodeTextView.text = roomCode
    }
}
