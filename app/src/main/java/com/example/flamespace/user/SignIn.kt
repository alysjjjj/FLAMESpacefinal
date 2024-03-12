package com.example.flamespace.user

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flamespace.buildings.Home
import com.example.flamespace.databinding.ActivitySignInBinding
import com.example.flamespace.retrofit.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignIn : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
            } else {
                // Call the login API
                val service = RetrofitHelper.getInstance()
                service.login(email, password).enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            Toast.makeText(
                                this@SignIn,
                                "Login successful",
                                Toast.LENGTH_SHORT
                            ).show()
                            // Navigate to the next screen or perform any other action
                        } else {
                            // Handle unsuccessful login
                            Toast.makeText(
                                this@SignIn,
                                "Login failed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        // Handle network error
                        Log.e("SignInActivity", "Network error: ${t.message}", t)
                        Toast.makeText(
                            this@SignIn,
                            "Network error. Please try again",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
            }
        }

        binding.tvHaventAccount.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }

        binding.tvForgotPw.setOnClickListener {
            startActivity(Intent(this, ForgotActivity::class.java))
        }
    }
}




