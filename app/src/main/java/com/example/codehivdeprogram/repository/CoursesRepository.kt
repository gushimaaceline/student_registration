package com.example.codehivdeprogram.repository

import com.example.codehivdeprogram.api.ApiClient
import com.example.codehivdeprogram.api.ApiInterface
import com.example.codehivdeprogram.models.SessionManager
import retrofit2.Response

class CoursesRepository {
    lateinit var sessionManager: SessionManager
    var apiInterface= ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun courses():Response<List<CoursesRepository>>= withContext(Dispatchers.IO){
        var response= apiInterface.studentCourses(token = "Bearer ${sessionManager.fetchAuthentication()}")
        return@withContext response
    }
    }

