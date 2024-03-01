package com.example.flamespace

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val baseUrl = "https://quiet-beach-04492-d8a02ae21cbc.herokuapp.com/?fbclid=IwAR2mDTs80hpezGwxL_orhohHXnwKOIB9_7WXLWbWiRNQ07SjeCxbG9PXq7A"

    fun getInstance(): Retrofit {
        return Retrofit
            .Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}