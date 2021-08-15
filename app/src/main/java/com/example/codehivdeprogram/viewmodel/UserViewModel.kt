package com.example.codehivdeprogram.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehivdeprogram.models.RegistrationRequest
import com.example.codehivdeprogram.models.RegistrationResponse
import com.example.codehivdeprogram.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    var registrationLiveData= MutableLiveData<RegistrationResponse>()
    var regFailedLiveData= MutableLiveData<String>()
    var userRepository= UserRepository()

    fun registerStudent(registrationRequest:RegistrationRequest:RegistrationRequest){
        viewModelScope.launch{
          var response= userRepository.registerStudent(registrationRequest){
              if (response.isSuccessful){
                  registrationRequest.postValue(response.body())
              }
              else{
                  regFailedLiveData.postValue(response.errorBody()?.string())
              }
          }
        }
    }


}