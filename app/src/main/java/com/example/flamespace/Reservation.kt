package com.example.flamespace

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.flamespace.R.id.save
import java.util.*
import android.app.TimePickerDialog
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import com.example.flamespace.R.id.datee
import java.text.SimpleDateFormat
import com.example.flamespace.R.id.spinnerPurpose



class Reservation : AppCompatActivity() {
    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var timePickerDialog: TimePickerDialog
    private lateinit var dateButton: Button
    private lateinit var timeButton: Button
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        dateButton = this.findViewById(R.id.datee)
        dateButton.text = getTodaysDate()

        timeButton = findViewById(R.id.timePickerButton)
        timeButton.text = getCurrentTime()

        initDatePicker()
        initTimePicker()



        val buttonClick = findViewById<ImageView>(R.id.backButton)
        buttonClick.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }


        val but = findViewById<Button>(/* id = */ save)
        but.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            Toast.makeText(this, "Reserved", Toast.LENGTH_SHORT).show()
        }
        val spinnerPurpose = findViewById<Spinner>(R.id.spinnerPurpose)
        val purposeChoices = arrayOf("Class", "Project", "Others")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, purposeChoices)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPurpose.adapter = adapter

        // Set spinner item selection listener
        spinnerPurpose.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> showClassDetails()
                    1 -> showProjectDetails()
                    2 -> showOtherDetails()
                }
    }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


    }

    private fun showClassDetails() {
        val classDetailsLayout = findViewById<LinearLayout>(R.id.classDetailsLayout)
        val projectDetailsLayout = findViewById<LinearLayout>(R.id.projectDetailsLayout)
        val otherDetailsEditText = findViewById<EditText>(R.id.otherDetailsEditText)

        // Show class details layout and hide others
        classDetailsLayout.visibility = View.VISIBLE
        projectDetailsLayout.visibility = View.GONE
        otherDetailsEditText.visibility = View.GONE
    }

    private fun showProjectDetails() {
        val classDetailsLayout = findViewById<LinearLayout>(R.id.classDetailsLayout)
        val projectDetailsLayout = findViewById<LinearLayout>(R.id.projectDetailsLayout)
        val otherDetailsEditText = findViewById<EditText>(R.id.otherDetailsEditText)

        // Show project details layout and hide others
        classDetailsLayout.visibility = View.GONE
        projectDetailsLayout.visibility = View.VISIBLE
        otherDetailsEditText.visibility = View.GONE
    }

    private fun showOtherDetails() {
        val classDetailsLayout = findViewById<LinearLayout>(R.id.classDetailsLayout)
        val projectDetailsLayout = findViewById<LinearLayout>(R.id.projectDetailsLayout)
        val otherDetailsEditText = findViewById<EditText>(R.id.otherDetailsEditText)

        // Show other details layout and hide others
        classDetailsLayout.visibility = View.GONE
        projectDetailsLayout.visibility = View.GONE
        otherDetailsEditText.visibility = View.VISIBLE
    }

    private fun getTodaysDate(): String {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH) + 1
        val day = cal.get(Calendar.DAY_OF_MONTH)
        return makeDateString(day, month, year)
    }

    private fun initDatePicker() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        val style = AlertDialog.THEME_HOLO_LIGHT

        datePickerDialog = DatePickerDialog(
            this, style,
            { _, year, month, day ->
                val selectedDate = makeDateString(day, month , year)
                dateButton.text = selectedDate
            }, year, month, day
        )

        dateButton.setOnClickListener {
            datePickerDialog.show()
        }
    }

    private fun makeDateString(day: Int, month: Int, year: Int): String {
        val monthStr = when (month) {
            Calendar.JANUARY -> "JAN"
            Calendar.FEBRUARY -> "FEB"
            Calendar.MARCH -> "MAR"
            Calendar.APRIL -> "APR"
            Calendar.MAY -> "MAY"
            Calendar.JUNE -> "JUN"
            Calendar.JULY -> "JUL"
            Calendar.AUGUST -> "AUG"
            Calendar.SEPTEMBER -> "SEP"
            Calendar.OCTOBER -> "OCT"
            Calendar.NOVEMBER -> "NOV"
            Calendar.DECEMBER -> "DEC"
            else -> "JAN"
        }
        return "$monthStr $day $year"
    }

    private fun getCurrentTime(): String {
        val cal = Calendar.getInstance()
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        val minute = cal.get(Calendar.MINUTE)
        return makeTimeString(hour, minute)
    }
    private fun initTimePicker() {
        val cal = Calendar.getInstance()
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        val minute = cal.get(Calendar.MINUTE)

        timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                val selectedTime = makeTimeString(hourOfDay, minute)
                timeButton.text = selectedTime
            }, hour, minute, false
        )

        timeButton.setOnClickListener {
            timePickerDialog.show()
        }
    }

    private fun makeTimeString(hour: Int, minute: Int): String {
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        return timeFormat.format(calendar.time)
    }
}