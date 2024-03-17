package com.example.flamespace.buildings

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flamespace.R
import com.example.flamespace.retrofit.RetrofitHelper
import com.example.flamespace.retrofit.Room
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Ptc<ImageView : View?> : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        // Initialize views and set up RecyclerView
        val backButton = findViewById<ImageView>(R.id.backButton)
        if (backButton != null) {
            backButton.setOnClickListener {
                onBackPressed()
            }
        }

        val recyclerView = findViewById<RecyclerView>(R.id.ptc_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch rooms grouped by buildings from API
        fetchRoomsGroupedByBuilding(recyclerView)
    }

    private fun fetchRoomsGroupedByBuilding(recyclerView: RecyclerView) {
        val apiService = RetrofitHelper.getService()
        val call = apiService.getRooms()

        call.enqueue(object : Callback<List<Room>> {
            override fun onResponse(call: Call<List<Room>>, response: Response<List<Room>>) {
                if (response.isSuccessful) {
                    val rooms = response.body()
                    if (rooms != null) {
                        // Filter rooms for the "PTC" building
                        val ptcRooms = rooms.filter { it.building == "PTC" }
                        // Group rooms by building
                        val roomsByBuilding = ptcRooms.groupBy { it.building }
                        val adapter = RoomAdapter(roomsByBuilding)
                        recyclerView.adapter = adapter
                    }
                } else {
                    // Handle error
                    Toast.makeText(this@Ptc, "Failed to fetch rooms", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Room>>, t: Throwable) {
                // Handle failure
                Toast.makeText(this@Ptc, "Network error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    // Function to fetch latest rooms after adding a room
    private fun fetchLatestRooms() {
        val recyclerView = findViewById<RecyclerView>(R.id.ptc_recycler)
        fetchRoomsGroupedByBuilding(recyclerView)
    }

    // Assume you have a function to add a new room
    private fun addNewRoom() {
        // Code to add a new room
        // After adding a room, fetch the latest rooms
        fetchLatestRooms()
    }
}


//        findViewById<CardView>(R.id.ptc_201).setOnClickListener {
//            showPopup("PTC 201", "50 chairs\n1 air conditioner working")
//        }
//
//        findViewById<CardView>(R.id.ptc_301).setOnClickListener {
//            showPopup("PTC 301", "45 chairs\n2 air conditioner working")
//        }
//
//        findViewById<CardView>(R.id.ptc_302).setOnClickListener {
//            showPopup("PTC 302", "60 chairs\n3 air conditioner working")
//        }
//
//        findViewById<CardView>(R.id.ptc_303).setOnClickListener {
//            showPopup("PTC 303", "55 chairs\n2 air conditioner working")
//        }
//
//        findViewById<CardView>(R.id.ptc_304).setOnClickListener {
//            showPopup("PTC 304", "40 chairs\n1 air conditioner working")
//        }
//
//        findViewById<CardView>(R.id.ptc_305).setOnClickListener {
//            showPopup("PTC 305", "48 chairs\n2 air conditioner working")
//        }
//
//        findViewById<CardView>(R.id.ptc_306).setOnClickListener {
//            showPopup("PTC 306", "48 chairs\n2 air conditioner working")
//        }
//        findViewById<CardView>(R.id.ptc_403).setOnClickListener {
//            showPopup("PTC 403", "48 chairs\n2 air conditioner working")
//        }
//        findViewById<CardView>(R.id.ptc_404).setOnClickListener {
//            showPopup("PTC 404", "48 chairs\n2 air conditioner working")
//        }
//        findViewById<CardView>(R.id.ptc_405).setOnClickListener {
//            showPopup("PTC 405", "48 chairs\n2 air conditioner working")
//        }
//        findViewById<CardView>(R.id.ptc_406).setOnClickListener {
//            showPopup("PTC 406", "48 chairs\n2 air conditioner working")
//        }


