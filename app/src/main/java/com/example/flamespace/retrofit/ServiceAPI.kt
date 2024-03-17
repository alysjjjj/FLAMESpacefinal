package com.example.flamespace.retrofit

import retrofit2.Call
import retrofit2.http.*

interface ServiceAPI {

    @GET("/api/users")
    fun getUsers(): Call<List<User>>

    @POST("/api/users")
    fun signUp(@Body user: UserRequestBody): Call<User>

    @POST("/api/auth/login")
    fun loginUser(@Body loginUser: LoginUser): Call<LoginResponse>

    @GET("/api/users/{id}")
    fun getUserById(@Path("id") id: String): Call<User>

    @PUT("/api/users/{id}")
    fun updateUser(@Path("id") id: Int, @Body user: UserRequestBody): Call<User>

    @DELETE("/api/users/{id}")
    fun deleteUser(@Path("id") id: Int): Call<Void>

    @POST("/resetPassword")
    @FormUrlEncoded
    fun resetPassword(@Field("email") email: String): Call<Void>

    @POST("/api/schedules")
    fun createReservation(
        @Body reservation: ReservationRequestBody
    ): Call<ReservationResponse>

    @GET("/api/rooms")
    fun getRooms(): Call<List<Room>>

    fun createReservation(@Query("roomCode") roomCode: String, @Query("selectedTime") selectedTime: String,@Query("subject") subject: String): Call<ReservationResponse>
    abstract fun createReservation(roomCode: String, selectedTime: String, selectedTime2: String, subject: String): Any
}
