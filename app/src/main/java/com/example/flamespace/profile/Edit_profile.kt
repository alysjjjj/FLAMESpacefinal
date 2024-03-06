package com.example.flamespace.profile

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.flamespace.R
import com.example.flamespace.databinding.ActivityEditProfileBinding

class Edit_profile : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var nameEditText: EditText
    private lateinit var blockEditText: EditText
    private lateinit var buttonsave: Button
    private lateinit var profileImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameEditText = binding.name
        blockEditText = binding.blk
        buttonsave = binding.buttonsave
        profileImageView = binding.profilePic

        loadProfileData()

        binding.profilePic.setOnClickListener {
            // Open gallery for image selection
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, REQUEST_IMAGE_GALLERY)
        }

        val backButton: FrameLayout = findViewById(R.id.backButton)
        backButton.setOnClickListener { onBackPressed() }
    }

    private fun loadProfileData() {
        // Load profile name and department
        val profileName = "Elyssa Salvador"
        val department = "CITE"

        nameEditText.setText(profileName)
        blockEditText.setText(department)

        // Load profile picture using Glide or Picasso
        val profileImageUrl = "URL_TO_YOUR_PROFILE_IMAGE"
        Glide.with(this)
            .load(profileImageUrl)
            .placeholder(R.drawable.dp) // Placeholder image
            .error(R.drawable.dp) // Error image
            .into(profileImageView)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_GALLERY && resultCode == RESULT_OK && data != null) {
            val imageUri = data.data
            // Handle image URI (upload to server, etc.)
            // For example, you can display the selected image directly using Glide:
            Glide.with(this)
                .load(imageUri)
                .into(profileImageView)
        }
    }



    companion object {
        private const val REQUEST_IMAGE_GALLERY = 100
    }
}
