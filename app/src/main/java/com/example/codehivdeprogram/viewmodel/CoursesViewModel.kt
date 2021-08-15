package com.example.codehivdeprogram.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehivdeprogram.models.CoursesResponse
import com.example.codehivdeprogram.repository.CoursesRepository
import kotlinx.coroutines.launch

class CoursesViewModel:ViewModel(){
    var coursesLiveData= MutableLiveData<List<CoursesResponse>>()
    var courseFailedLiveData= MutableLiveData<String>()
    var coursesResponse= CoursesRepository()

    fun courseList(){
        viewModelScope.launch {
            var response= courseRepository.courses()
            if (response.isSuccessful){
                courseFailedLiveData.postValue(response.body())
            }
            else{
                courseFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}