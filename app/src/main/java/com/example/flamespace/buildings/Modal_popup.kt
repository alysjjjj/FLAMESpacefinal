package com.example.flamespace.buildings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.flamespace.R
import com.example.flamespace.user.Reservation

class Modal_popup : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_modal_popup, container, false)

        // Get the room code from the arguments bundle
        val roomCode = arguments?.getString("ROOM_CODE")

        // Set the room code to the TextView
        val roomCodeTextView = view.findViewById<TextView>(R.id.roomCodeTextView)
        roomCodeTextView.text = roomCode

        // Set up button click listener
        val buttonClick = view.findViewById<Button>(R.id.reserveButton)
        buttonClick.setOnClickListener {
            // Handle button click
            val intent = Intent(requireActivity(), Reservation::class.java)
            intent.putExtra("ROOM_CODE", roomCode) // Assuming roomCode is obtained from the selected room
            startActivity(intent)
            dismiss() // Dismiss the dialog after starting the activity
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        // Apply blurry background when the dialog is resumed (shown)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}
