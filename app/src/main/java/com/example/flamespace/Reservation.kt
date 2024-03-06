package com.example.flamespace

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

class Reservation : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val backButton = findViewById<android.widget.ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            goBackToPreviousPage()
        }

        val saveButton = findViewById<Button>(R.id.btnreserve)
        saveButton.setOnClickListener {
            saveReservation()
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
                // Do something with the selected time
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }

    private fun goBackToPreviousPage() {
        onBackPressed()
    }

    private fun navigateToCurrentActivity(roomCode: String) {
        val intent = Intent(this, Current::class.java)
        intent.putExtra("ROOM_CODE", roomCode)
        startActivity(intent)
    }

    private fun saveReservation() {
        // Implement save reservation logic here

        val intent = Intent(this, Current::class.java)
        startActivity(intent)
        Toast.makeText(this, "Room reserved", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        // Handle clicks if needed
    }
}
