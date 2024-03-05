package com.example.flamespace

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Logout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_logout)

        val btnLogout = findViewById<android.widget.Button>(R.id.btnLogout)
        val btnCancel = findViewById<android.widget.Button>(R.id.btnCancel)

        btnLogout.setOnClickListener {
            logout()
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun logout() {
        clearSessionData()
        navigateToLoginScreen()
    }

    private fun clearSessionData() {
        val sharedPreferences = getSharedPreferences("YourSessionData", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.clear()
        editor.apply()
    }

    private fun navigateToLoginScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}