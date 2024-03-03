package com.example.flamespace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.flamespace.R.id.be
import com.example.flamespace.R.id.cahs
import com.example.flamespace.R.id.cite
import com.example.flamespace.R.id.cma
import com.example.flamespace.R.id.mba
import com.example.flamespace.R.id.nh
import com.example.flamespace.R.id.profile

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val button = findViewById<ImageView>(cite)
        button.setOnClickListener {
            val int = Intent(this, Ptc::class.java)
            startActivity(int)
        }

        val btn = findViewById<ImageView>(profile)
        btn.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        val btn2 = findViewById<ImageView>(cma)
        btn2.setOnClickListener {
            val int = Intent(this, Cma::class.java)
            startActivity(int)
        }

        val btn3 = findViewById<ImageView>(mba)
        btn3.setOnClickListener {
            val int = Intent(this, Mba::class.java)
            startActivity(int)
        }

        val btn4 = findViewById<ImageView>(nh)
        btn4.setOnClickListener {
            val int = Intent(this, Nh::class.java)
            startActivity(int)
        }

        val btn5 = findViewById<ImageView>(cahs)
        btn5.setOnClickListener {
            val int = Intent(this, Cahs::class.java)
            startActivity(int)
        }

        val btn6 = findViewById<ImageView>(be)
        btn6.setOnClickListener {
            val int = Intent(this, Be::class.java)
            startActivity(int)
        }


    }
}