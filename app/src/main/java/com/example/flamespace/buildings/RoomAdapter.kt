package com.example.flamespace.buildings

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flamespace.R
import com.example.flamespace.retrofit.Room
import com.example.flamespace.user.Reservation

class RoomAdapter(private val roomsByBuilding: Map<String, List<Room>>) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rooms_rv, parent, false)
        return RoomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val building = roomsByBuilding.keys.toList()[position]
        val rooms = roomsByBuilding[building] ?: emptyList()
        holder.bind(building, rooms)
    }

    override fun getItemCount(): Int {
        return roomsByBuilding.size
    }

    inner class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(building: String, rooms: List<Room>) {
            if (rooms.isNotEmpty()) {
                itemView.setOnClickListener {
                    val context = itemView.context
                    val room = rooms[adapterPosition]
                    val intent = Intent(context, Reservation::class.java).apply {
                        putExtra("BUILDING", building)
                        putExtra("ROOM_CODE", room.roomNumber)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }

}
