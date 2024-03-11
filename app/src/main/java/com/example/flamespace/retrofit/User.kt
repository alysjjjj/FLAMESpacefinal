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
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
data class LoginUser(
    val email: String,
    val password: String
)

data class LoginResponse(
    @SerializedName("token")
    val token: String // Assuming the login endpoint returns a token
)
