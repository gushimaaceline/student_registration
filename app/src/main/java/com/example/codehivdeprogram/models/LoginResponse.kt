package com.example.codehivdeprogram.models

import android.provider.ContactsContract

data class LoginResponse(
    var message: String,
    var access_token: String,
    var student_id: String
)
