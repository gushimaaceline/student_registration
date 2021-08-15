package com.example.codehivdeprogram.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registration.models.LogInRequest
import com.example.registration.models.LogInResponse
import com.example.registration.repository.UserRepository
import kotlinx.coroutines.launch

class LogInViewModel:ViewModel() {
    var logInLiveData = MutableLiveData<LogInResponse>()
    var logInFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()
    
    fun logIn(logInRequest: LogInRequest){
        viewModelScope.launch { 
            var response = userRepository.login(logInRequest,)
            if (response.isSuccessful){
                logInLiveData.postValue(response.body())
            }
            else{
                logInFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
