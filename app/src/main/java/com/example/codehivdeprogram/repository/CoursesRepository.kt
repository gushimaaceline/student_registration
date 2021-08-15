package com.example.registration.repository

import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoursesRepository {
    lateinit var sessionManager: SessionManager
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun courses(): Response<List<CoursesResponse>> =
        withContext(Dispatchers.IO){
            var response=apiInterface.studentCourses(token="Bearer ${sessionManager.fetchAuthentication()}")
            return@withContext response

        }
}

