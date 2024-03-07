package com.example.flamespace.user

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.flamespace.R
import com.example.flamespace.profile.Current

class Reservation : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val backButton = findViewById<android.widget.ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            goBackToPreviousPage()
        }

        val roomCode = intent.getStringExtra("ROOM_CODE")
        val roomCodeTextView = findViewById<android.widget.TextView>(R.id.room_code)
        roomCodeTextView.text = roomCode

        // Time picker setup
        val timePicker = findViewById<Spinner>(R.id.timePicker)
        ArrayAdapter.createFromResource(
            this,
            R.array.time_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            timePicker.adapter = adapter
        }

        timePicker.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                val selectedTime = parent.getItemAtPosition(position).toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        val saveButton = findViewById<Button>(R.id.btnreserve)
        saveButton.setOnClickListener {
            val roomCode = intent.getStringExtra("ROOM_CODE") ?: ""
            val selectedTime = timePicker.selectedItem.toString() // Retrieve selected time
            saveReservation(roomCode, selectedTime)
        }
    }

    private fun navigateToCurrentActivity(roomCode: String, selectedTime: String, subject: String) {
        val intent = Intent(this, Current::class.java).apply {
            putExtra("ROOM_CODE", roomCode)
            putExtra("SELECTED_TIME", selectedTime)
            putExtra("SUBJECT", subject)
        }
        startActivity(intent)
    }

    private fun goBackToPreviousPage() {
        onBackPressed()
    }

    private fun saveReservation(roomCode: String, selectedTime: String) {
        val subjectEditText = findViewById<EditText>(R.id.subject_edittext)
        val subject = subjectEditText.text.toString().trim()

        navigateToCurrentActivity(roomCode, selectedTime, subject)
        Toast.makeText(this, "Room reserved", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {

    }
}
