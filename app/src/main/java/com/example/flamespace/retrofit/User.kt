package com.example.flamespace.retrofit

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
