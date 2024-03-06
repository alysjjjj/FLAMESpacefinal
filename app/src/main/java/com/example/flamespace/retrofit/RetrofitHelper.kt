package com.example.flamespace.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val BASE_URL = "https://quiet-beach-04492-d8a02ae21cbc.herokuapp.com/"

    fun getInstance(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client) // Set the custom OkHttpClient
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}



//https://quiet-beach-04492-d8a02ae21cbc.herokuapp.com/
//https://jsonplaceholder.typicode.com/