package com.example.codehivdeprogram.repository

import com.example.codehivdeprogram.api.ApiClient
import com.example.codehivdeprogram.api.ApiInterface
import com.example.codehivdeprogram.models.LoginRequest
import com.example.codehivdeprogram.models.LoginResponse
import com.example.codehivdeprogram.models.RegistrationRequest
import com.example.codehivdeprogram.models.RegistrationResponse
import kotlinx.coroutines.Dispatchers.IO
import okhttp3.Dispatcher
import retrofit2.Response

class UserRepository {
    var apiInterface= ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun registerStudent(registrationRequest: RegistrationRequest):Response<RegistrationResponse> = withContex(Dispatcher.IO){
        var response= apiInterface.registerStudent(registrationRequest)
        return@withContex response

    }
    suspend fun logIn(loginRequest: LoginRequest):Response<LoginResponse>=
    withContext(Dispatchers.IO){
        var response= apiInterface.loginStudent(loginRequest)
        return@withContext response
    }

}