package com.example.flamespace

import retrofit2.Response
import retrofit2.http.GET

interface ServiceAPI {
    @GET("posts/1")
    suspend fun getPosts(): Response<Reservations>

}