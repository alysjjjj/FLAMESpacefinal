package com.example.flamespace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout

class Edit_profile : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var blockEditText: EditText
    private lateinit var buttonsave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        nameEditText = findViewById(R.id.name)
        blockEditText = findViewById(R.id.blk)
        buttonsave = findViewById(R.id.buttonsave)


        loadProfileData()



        val backButton = findViewById<FrameLayout>(R.id.backButton)
        backButton.setOnClickListener {

            goBackToPreviousPage()
        }


    }
    private fun goBackToPreviousPage() {
        onBackPressed()
    }

    private fun loadProfileData() {

        val profileName = "Elyssa Salvador"
        val department = "CITE"


        nameEditText.setText(profileName)
        blockEditText.setText(department)
    }



}