package com.example.codehivdeprogram.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehivdeprogram.models.LoginRequest
import com.example.codehivdeprogram.models.LoginResponse
import com.example.codehivdeprogram.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    var loginLiveData= MutableLiveData<LoginResponse>()
    var loginFailedLiveData= MutableLiveData<String>()
    var userRepository= UserRepository()

    fun logIn(loginRequest: LoginRequest){
        viewModelScope.launch {
            var response= userRepository.logIn(loginRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }
            else{
                loginFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}