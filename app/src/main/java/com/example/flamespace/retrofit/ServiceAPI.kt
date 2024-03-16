package com.example.flamespace.retrofit

import retrofit2.Call
import retrofit2.http.*

interface ServiceAPI {

    @GET("/users")
    fun getUsers(): Call<List<User>>

    @POST("/api/users")
    fun signUp(@Body user: UserRequestBody): Call<User>

    @POST("/api/auth/login")
    fun loginUser(@Body loginUser: LoginUser): Call<LoginResponse>

    @PUT("/users/{id}")
    fun updateUser(@Path("id") id: Int, @Body user: UserRequestBody): Call<User>

    @DELETE("/users/{id}")
    fun deleteUser(@Path("id") id: Int): Call<Void>

    @POST("/resetPassword")
    @FormUrlEncoded
    fun resetPassword(@Field("email") email: String): Call<Void>

    @POST("/api/schedules")
    fun createReservation(@Query("roomCode") roomCode: String, @Query("selectedTime") selectedTime: String, @Query("selectedTime2") selectedTime2: String, @Query("subject") subject: String): Call<ReservationResponse>
}

