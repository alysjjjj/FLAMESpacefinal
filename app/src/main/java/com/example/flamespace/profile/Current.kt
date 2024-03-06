package com.example.flamespace.profile


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
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

        val roomCodeTextView = findViewById<android.widget.TextView>(R.id.current_room)
        val timeTextView = findViewById<android.widget.TextView>(R.id.current_schedule)
        val subjectTextView = findViewById<android.widget.TextView>(R.id.current_subject)

        roomCodeTextView.text = roomCode
        timeTextView.text = selectedTime
        subjectTextView.text = subject
    }

}