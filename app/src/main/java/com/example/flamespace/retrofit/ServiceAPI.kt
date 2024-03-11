package com.example.flamespace.retrofit

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ServiceAPI {
    // Define an endpoint for sign up
    @FormUrlEncoded
    @POST("/auth/register") // Adjust the endpoint path as per your backend API
    fun signUp(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Void>

    // Define an endpoint for login
    @FormUrlEncoded
    @POST("/auth/login") // Adjust the endpoint path as per your backend API
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Void>

    @FormUrlEncoded
    @POST("/auth/reset_password") // Adjust the endpoint path as per your backend API
    fun resetPassword(
        @Field("email") email: String
    ): Call<Void>

    @Multipart
    @POST("/upload/profile/image")
    fun uploadProfileImage(
        @Part image: MultipartBody.Part
    ): Call<String>

    @GET("/users")
    fun getPosts(): Call<List<Post>>

    @GET("/users/{id}")
    fun getUsers(): Call<List<User>>

    //added
    @GET("user")
    fun getUser(): Call<List<User>>
    @POST("api/auth/signup")
    fun register(@Body user: User):Call<User>
    @POST("api/auth/login")
    fun loginUser(@Body loginUser: LoginUser): Call<LoginResponse>
}


