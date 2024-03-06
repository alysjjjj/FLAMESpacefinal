package com.example.flamespace.retrofit

data class Reservations(
    val userId: Int,
    val studentId: Int,
    val roomNumber: String,
    val startTime: String,
    val endTime: String,
    var isAvailable: Boolean,
    val purpose: String, // Purpose of the reservation
    val instructorName: String?, // Instructor's Name (for Class purpose)
    val section: String?, // Section (for Class and Project purposes)
    val subjectCode: String?, // Subject Code (for Class purpose)
    val projectSubject: String?, // Subject of the Project (for Project purpose)
    val projectDescription: String?, // Description for Project (for Project purpose)
    val otherDescription: String? // Description for Other purpose
)
