package com.example.flamespace.user

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flamespace.buildings.Home
import com.example.flamespace.databinding.ActivitySignUpBinding
import com.example.flamespace.retrofit.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Signup : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etSignupEmail.text.toString().trim()
            val password = binding.etSignupPassword.text.toString().trim()
            val rePassword = binding.etSignupRepassword.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
            } else if (password != rePassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                signUp(name, email, password)
            }
        }

        binding.tvHaveAccount.setOnClickListener {
            startActivity(Intent(this, SignIn::class.java))
        }
    }

    private fun signUp(name: String, email: String, password: String) {
        val service = RetrofitHelper.getInstance()
        service.signUp(name, email, password).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@Signup, "Sign up successful", Toast.LENGTH_SHORT).show()
                    // Call the login API upon successful sign up
                    login(email, password)
                } else {
                    handleSignUpFailure(response)
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("Signup", "Network error: ${t.message}", t)
                Toast.makeText(
                    this@Signup,
                    "Network error. Please try again",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun login(email: String, password: String) {
        val service = RetrofitHelper.getInstance()
        service.login(email, password).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    // Login successful
                    startActivity(Intent(this@Signup, Home::class.java))
                    finish()
                } else {
                    handleLoginFailure(response)
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // Handle network error
                Log.e("Signup", "Login network error: ${t.message}", t)
                Toast.makeText(
                    this@Signup,
                    "Login network error. Please try again",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun handleSignUpFailure(response: Response<Void>) {
        val errorBody = response.errorBody()?.string()
        Log.e("Signup", "Sign up failed: ${response.code()}, $errorBody")
        Toast.makeText(
            this@Signup,
            "Sign up failed. Please check logs for details",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun handleLoginFailure(response: Response<Void>) {
        val errorBody = response.errorBody()?.string()
        Log.e("Signup", "Login failed after sign up: ${response.code()}, $errorBody")
        Toast.makeText(
            this@Signup,
            "Login failed after sign up. Please check logs for details",
            Toast.LENGTH_SHORT
        ).show()
    }
}
