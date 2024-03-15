package com.example.flamespace.retrofit

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("password")
    val password: String? = null,

    @SerializedName("confirm_password")
    val confirm_password: String? = null,
)
data class LoginUser(
    val email: String,
    val password: String
)

data class LoginResponse(
    val token: String,
    val user: User,
    val message: String // Add this field if your server sends a message
)


data class UserRequestBody(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)

data class ReservationResponse(
    val status: String,
    val message: String
)
