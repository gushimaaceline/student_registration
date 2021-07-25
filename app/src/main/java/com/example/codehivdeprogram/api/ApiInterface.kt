package com.example.codehivdeprogram.api

import com.example.codehivdeprogram.models.LoginRequest
import com.example.codehivdeprogram.models.LoginResponse
import com.example.codehivdeprogram.models.RegistrationRequest
import com.example.codehivdeprogram.models.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    fun registerStudent(@Body registrationRequest: RegistrationRequest):Call<RegistrationResponse>
    @POST("/students/login")
    fun loginStudent(@Body loginRequest:LoginRequest): Call<LoginResponse>

}