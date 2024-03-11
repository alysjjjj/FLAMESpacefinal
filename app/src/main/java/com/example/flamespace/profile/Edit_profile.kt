package com.example.flamespace.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.flamespace.R
import com.example.flamespace.databinding.ActivityEditProfileBinding
import com.bumptech.glide.Glide
import com.example.flamespace.user.SignIn

class Edit_profile : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var nameEditText: EditText
    private lateinit var departmentSpinner: Spinner
    private lateinit var buttonSave: Button
    private lateinit var profileImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonClick = findViewById<FrameLayout>(R.id.backButton)
        buttonClick.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        nameEditText = binding.name
        departmentSpinner = binding.departmentSave
        buttonSave = binding.buttonsave
        profileImageView = binding.profilePic

        loadProfileData()

        binding.profilePic.setOnClickListener {
            // Open gallery
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, REQUEST_IMAGE_GALLERY)
        }

        buttonSave.setOnClickListener {
            val newName = nameEditText.text.toString()
            val newDepartment = departmentSpinner.selectedItem.toString()

            saveProfileData(newName, newDepartment)

            val intent = Intent(this@Edit_profile, Profile::class.java)
            intent.putExtra("newName", newName)
            intent.putExtra("newDepartment", newDepartment)
            startActivity(intent)
        }

        // spinner
        val departmentOptions = arrayOf("CITE", "CMA", "CAS", "CEA", "CAHS", "CELA", "CCJE")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, departmentOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        departmentSpinner.adapter = adapter
    }

    private fun loadProfileData() {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val profileName = sharedPreferences.getString("name", "")
        val department = sharedPreferences.getString("department", "")

        nameEditText.setText(profileName)
        val departmentPosition = department?.let { departmentSpinner.selectedItemPosition }
        departmentPosition?.let { departmentSpinner.setSelection(it) }


        val profileImageUrl = "URL_TO_YOUR_PROFILE_IMAGE"
        Glide.with(this@Edit_profile)
            .load(profileImageUrl)
            .placeholder(R.drawable.profile_pic) // Placeholderimage
            .error(R.drawable.profile_pic) // Errorimage
            .into(profileImageView)
    }

    private fun saveProfileData(name: String, department: String) {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("department", department)
        editor.apply()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_GALLERY && resultCode == RESULT_OK && data != null) {
            val imageUri = data.data
            Glide.with(this@Edit_profile)
                .load(imageUri)
                .into(profileImageView)
        }
    }

    companion object {
        private const val REQUEST_IMAGE_GALLERY = 100
    }
}
