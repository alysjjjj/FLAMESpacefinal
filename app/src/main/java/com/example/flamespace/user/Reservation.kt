package com.example.flamespace.user


import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.flamespace.R
import com.example.flamespace.profile.Current
import com.example.flamespace.retrofit.ReservationRequestBody
import com.example.flamespace.retrofit.RetrofitHelper
import com.example.flamespace.retrofit.ReservationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class Reservation : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        // Initialize UI elements
        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            goBackToPreviousPage()
        }


        val roomCode = intent.getStringExtra("ROOM_CODE") ?: ""
        val roomCodeTextView = findViewById<TextView>(R.id.room_code)
        // Retrieve room code from intent and set it to the TextView
        val roomCode = intent.getStringExtra("ROOM_CODE") ?: ""
        val roomCodeTextView = findViewById<TextView>(R.id.room_code)
        roomCodeTextView.text = roomCode

        //  for Time Start
        val timeStartEditText: EditText = findViewById(R.id.timePicker)
        timeStartEditText.setOnClickListener {
            showTimePickerDialog(timeStartEditText)
        // Setup Spinners for selecting start and end times
        val timePicker = findViewById<Spinner>(R.id.timePicker)
        ArrayAdapter.createFromResource(
            this,
            R.array.time_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            timePicker.adapter = adapter
        }

        // for Time End
        val timeEndEditText: EditText = findViewById(R.id.timePickerEditText)
        timeEndEditText.setOnClickListener {
            showTimePickerDialog(timeEndEditText)
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
            val selectedTime = timeStartEditText.text.toString()
            val subjectEditText = findViewById<EditText>(R.id.subject_edittext)
            val subject = subjectEditText.text.toString().trim()
            saveReservation(roomCode, selectedTime, subject)
            val selectedTime = timePicker.selectedItem.toString()
            val selectedTime2 = timeEnd.selectedItem.toString()
            val subjectEditText = findViewById<EditText>(R.id.subject_edittext)
            val subject = subjectEditText.text.toString().trim()
            saveReservation(roomCode, selectedTime, selectedTime2, subject)
        }
    }

    private fun showTimePickerDialog(editText: EditText) {
        val calendar = Calendar.getInstance()
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        // Create a time picker dialog with custom format and AM/PM selection
        val timePickerDialog = TimePickerDialog(
            this,
            { _, selectedHour, selectedMinute ->
                // Update EditText with selected time
                val formattedTime = formatTime(selectedHour, selectedMinute)
                editText.setText(formattedTime)
            },
            hourOfDay,
            minute,
            false // Set is24HourView to false to display in 12-hour format
        )

        // Show the time picker dialog
        timePickerDialog.show()
    }

    private fun formatTime(hour: Int, minute: Int): String {
        val formattedHour = when {
            hour == 0 -> 12
            hour > 12 -> hour - 12
            else -> hour
        }
        val formattedMinute = String.format("%02d", minute)
        val amPm = if (hour < 12) "AM" else "PM"
        return "$formattedHour:$formattedMinute $amPm"
    }

    private fun navigateToCurrentActivity(roomCode: String, selectedTime: String, subject: String) {

    private fun navigateToCurrentActivity(roomCode: String, selectedTime: String, selectedTime2: String, subject: String) {
        val intent = Intent(this, Current::class.java).apply {
            putExtra("ROOM_CODE", roomCode)
            putExtra("SELECTED_TIME", selectedTime)
            putExtra("SUBJECT", subject)
        }
        startActivity(intent)
    }

    private fun goBackToPreviousPage() {
        Log.d("ReservationActivity", "Going back to previous page")
        onBackPressed()
    }

    private fun saveReservation(roomCode: String, selectedTime: String, subject: String) {
    private fun saveReservation(roomCode: String, selectedTime: String, selectedTime2: String, subject: String) {
        // Validate subject before proceeding
        if (subject.isEmpty()) {
            Toast.makeText(this, "Please enter a subject", Toast.LENGTH_SHORT).show()
            return
        }

        // Retrofit service initialization
        val service = RetrofitHelper.getService()
        val call = service.createReservation(roomCode, selectedTime, subject)

        // Create reservation request
        val reservationRequestBody = ReservationRequestBody(roomCode, selectedTime, selectedTime2, subject)
        val call = service.createReservation(reservationRequestBody)

        call.enqueue(object : Callback<ReservationResponse> {
            override fun onResponse(call: Call<ReservationResponse>, response: Response<ReservationResponse>) {
                if (response.isSuccessful) {
                    // Handle success response
                    val reservationResponse = response.body()
                    Toast.makeText(this@Reservation, "Reservation successful", Toast.LENGTH_SHORT).show()
                    navigateToCurrentActivity(roomCode, selectedTime, subject)
                    navigateToCurrentActivity(roomCode, selectedTime, selectedTime2, subject)
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

    // Add other methods as needed
}
