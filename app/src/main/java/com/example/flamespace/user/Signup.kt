package com.example.flamespace.user

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.flamespace.buildings.Home
import com.example.flamespace.databinding.ActivitySignUpBinding
import com.example.flamespace.retrofit.RetrofitHelper
import com.example.flamespace.retrofit.User
import com.example.flamespace.retrofit.UserRequestBody
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
        val service = RetrofitHelper.getService()
        val userRequestBody = UserRequestBody(name = name, email = email, password = password)
        service.signUp(userRequestBody).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@Signup, "Sign up successful", Toast.LENGTH_SHORT).show()
                    // Upon successful sign up, attempt login
                    login(email, password)
                } else {
                    handleSignUpFailure(response)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("Signup", "Network error: ${t.message}", t)
                Toast.makeText(this@Signup, "Network error. Please try again", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun login(email: String, password: String) {
        // Implement your login logic here
    }

    private fun handleSignUpFailure(response: Response<User>) {
        val errorBody = response.errorBody()?.string()
        Log.e("Signup", "Sign up failed: ${response.code()}, $errorBody")
        Toast.makeText(this@Signup, "Sign up failed. Please check logs for details", Toast.LENGTH_SHORT).show()
    }
}
