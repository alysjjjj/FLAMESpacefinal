package com.example.flamespace

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.flamespace.R.id.cite
import com.example.flamespace.R.id.profile

class Home : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val buttonClick = findViewById<Button>(profile)
        buttonClick.setOnClickListener {
            val int= Intent(this, Profile::class.java)
            startActivity(int)
        }

        val button = findViewById<ImageView>(cite)
        button.setOnClickListener {
            val intent = Intent(this, Room::class.java)
            startActivity(intent)
        }
    }
}