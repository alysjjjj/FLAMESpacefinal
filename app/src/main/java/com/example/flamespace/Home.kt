package com.example.flamespace

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.flamespace.R.id.button2
import com.example.flamespace.R.id.button33
import com.example.flamespace.R.id.button4
import com.example.flamespace.R.id.button5
import com.example.flamespace.R.id.button6
import com.example.flamespace.R.id.cite
import com.example.flamespace.R.id.cma
import com.example.flamespace.R.id.profile
import com.example.flamespace.R.id.ptc

class Home : AppCompatActivity() {
    @SuppressLint( "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val button = findViewById<Button>(ptc)
        button.setOnClickListener {
            val int = Intent(this, Ptc_room::class.java)
            startActivity(int)
        }

        val btn = findViewById<ImageView>(profile)
        btn.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        val btn2 = findViewById<Button>(button2)
        btn2.setOnClickListener {
            val int = Intent(this, Cma_room::class.java)
            startActivity(int)
        }

        val btn3 = findViewById<Button>(button33)
        btn3.setOnClickListener {
            val int = Intent(this, Mba_room::class.java)
            startActivity(int)
        }

        val btn4 = findViewById<Button>(button4)
        btn4.setOnClickListener {
            val int = Intent(this, Nh_room::class.java)
            startActivity(int)
        }

        val btn5 = findViewById<Button>(button5)
        btn5.setOnClickListener {
            val int = Intent(this, Cahs_rooms::class.java)
            startActivity(int)
        }

        val btn6 = findViewById<Button>(button6)
        btn6.setOnClickListener {
            val int = Intent(this, Be::class.java)
            startActivity(int)
        }


    }
}