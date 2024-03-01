package com.example.flamespace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flamespace.R.id

class History : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val backButton = findViewById<FrameLayout>(id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.history_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = HistoryAdapter(getHistoryList())
    }

    private fun getHistoryList(): List<HistoryItem> {
        // Replace this with your actual data fetching logic
        val historyList = mutableListOf<HistoryItem>()
        // Add sample data
        historyList.add(HistoryItem("PTC 301", "Sched Example", "February 29, 2024"))
        // Add more items as needed
        return historyList
    }
}
