package com.example.flamespace.buildings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.flamespace.R
import com.example.flamespace.user.Reservation

class Modal_popup : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_modal_popup, container, false)

        val roomCodeTextView = view.findViewById<TextView>(R.id.roomCodeTextView)

        val buttonClick = view.findViewById<Button>(R.id.reserveButton)
        buttonClick.setOnClickListener {

            val roomCode = "PTC 201" // Example room code
            val intent = Intent(requireActivity(), Reservation::class.java)
            intent.putExtra("ROOM_CODE", roomCode) // Assuming roomCode is obtained from the selected room
            startActivity(intent)
        }

        // Get the room code from the arguments bundle
        val roomCode = arguments?.getString("ROOM_CODE")
        roomCodeTextView.text = roomCode

        return view
    }

}
