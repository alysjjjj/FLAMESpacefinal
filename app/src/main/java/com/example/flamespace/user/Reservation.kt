package com.example.flamespace.user

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.flamespace.R
import com.example.flamespace.profile.Current
import com.example.flamespace.retrofit.RetrofitHelper
import com.example.flamespace.retrofit.ReservationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Reservation : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        // Initialize UI elements
        val backButton = findViewById<android.widget.ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            goBackToPreviousPage()
        }

        // Retrieve room code from intent
        val roomCode = intent.getStringExtra("ROOM_CODE")
        val roomCodeTextView = findViewById<android.widget.TextView>(R.id.room_code)
        roomCodeTextView.text = roomCode

        // Setup spinner for selecting time options
        val timePicker = findViewById<Spinner>(R.id.timePicker)
        ArrayAdapter.createFromResource(
            this,
            R.array.time_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            timePicker.adapter = adapter
        }

        //time ends
        val timeEnd = findViewById<Spinner>(R.id.timeEnd)
        ArrayAdapter.createFromResource(
            this,
            R.array.time_ends,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            timeEnd.adapter = adapter
        }

        // Handle button click to save reservation
        val saveButton = findViewById<Button>(R.id.btnreserve)
        saveButton.setOnClickListener {
            val roomCode = intent.getStringExtra("ROOM_CODE") ?: ""
            val selectedTime = timePicker.selectedItem.toString()
            val selectedTime2 = timeEnd.selectedItem.toString()// Retrieve selected time
            saveReservation(roomCode, selectedTime, selectedTime2)
        }
    }
    private fun navigateToCurrentActivity(roomCode: String, selectedTime: String,selectedTime2: String, subject: String) {
        val intent = Intent(this, Current::class.java).apply {
            putExtra("ROOM_CODE", roomCode)
            putExtra("SELECTED_TIME", selectedTime)
            putExtra("SELECTED_TIME_2", selectedTime2)
            putExtra("SUBJECT", subject)
        }
        startActivity(intent)
    }

    private fun goBackToPreviousPage() {
        onBackPressed()
    }

    private fun saveReservation(roomCode: String, selectedTime: String, selectedTime2: String) {
        val subjectEditText = findViewById<EditText>(R.id.subject_edittext)
        val subject = subjectEditText.text.toString().trim()

        val service = RetrofitHelper.getService()
        val call = service.createReservation(roomCode, selectedTime, subject, selectedTime2)

        call.enqueue(object : Callback<ReservationResponse> {
            override fun onResponse(call: Call<ReservationResponse>, response: Response<ReservationResponse>) {
                if (response.isSuccessful) {
                    val reservationResponse = response.body()
                    // Handle success response
                    Toast.makeText(this@Reservation, "Reservation successful", Toast.LENGTH_SHORT).show()
                    // Optionally, you can navigate to another activity or perform other actions
                } else {
                    // Handle error response
                    Toast.makeText(this@Reservation, "Reservation failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ReservationResponse>, t: Throwable) {
                // Handle network errors
                Toast.makeText(this@Reservation, "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onClick(v: View?) {
        // Handle click events if needed
    }
}


//    private fun saveReservation(roomCode: String, selectedTime: String) {
//        val subjectEditText = findViewById<EditText>(R.id.subject_edittext)
//        val subject = subjectEditText.text.toString().trim()
//
//        navigateToCurrentActivity(roomCode, selectedTime, subject)
//        Toast.makeText(this, "Room reserved", Toast.LENGTH_SHORT).show()
//    }