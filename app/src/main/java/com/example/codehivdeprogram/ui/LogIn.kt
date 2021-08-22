package com.example.codehivdeprogram.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.registration.R
import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.databinding.ActivityLogInBinding
import com.example.registration.databinding.ActivityMainBinding
import com.example.registration.models.LogInRequest
import com.example.registration.models.LogInResponse
import com.example.registration.viewmodel.LogInViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogIn : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    val logInViewModel:LogInViewModel by viewModels()
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("CODEHIVE_REG_PREFS", Context.MODE_PRIVATE)
        binding.btnLogIn.setOnClickListener {
            var logInRequest = LogInRequest(binding.etEmailLogIn.text.toString(),
            binding.etPasswordLogIn.text.toString())
            logInViewModel.logIn(logInRequest)
        }
    }

    override fun onResume(){
        super.onResume()
        logInViewModel.logInLiveData.observe(this, { logInResponse->
            Toast.makeText(baseContext, logInResponse.message, Toast.LENGTH_LONG).show()
            var accessToken = logInResponse.accessToken
            sharedPreferences.edit().putString("ACCESS_TOKEN", accessToken).apply()
            var x = sharedPreferences.getString("ACCESS_TOKEN", "")
        })

        logInViewModel.logInFailedLiveData.observe(this, {error->
        Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        binding.tvLogInError.visibility=View.VISIBLE
            binding.tvLogInError.text = error
        })
        val intent = Intent(baseContext, CoursesActivity::class.java)
        startActivity(intent)
        
        
        
        
        
        
//        views()
//        logIn()

//    lateinit var etEmailLogIn: EditText
//    lateinit var etPasswordLogIn: EditText
//    lateinit var btnLogIn: Button

//    fun views() {
//        etEmailLogIn = findViewById(R.id.etEmailLogIn)
//        etPasswordLogIn = findViewById(R.id.etPasswordLogIn)
//        btnLogIn = findViewById(R.id.btnLogIn)
//
//    }
//
//    fun logIn() {
//
//        var error = false
//        btnLogIn.setOnClickListener {
//            var logInEmail = etEmailLogIn.text.toString()
//            if (logInEmail.isEmpty()) {
//                error = true
//                etEmailLogIn.setError("Email is required")
//            }
//            var idLogInPassword = etPasswordLogIn.text.toString()
//            if (idLogInPassword.isEmpty()) {
//                error = true
//                etPasswordLogIn.setError("ID Number required")
//            }
//
//            var logInRequest = LogInRequest(
//                email = logInEmail,
//                password = idLogInPassword
//            )
//
//
//            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
//            var request = retrofit.logInStudent(logInRequest)
//            request.enqueue(object : Callback<LogInResponse> {
//
//                override fun onResponse(
//                    call: Call<LogInResponse>,
//                    response: Response<LogInResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        Toast.makeText(baseContext, "LogIn successful", Toast.LENGTH_LONG)
//                            .show()
//                    }
//                }
//
//                override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
//                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//                }
//
//            })
//            val intent = Intent(baseContext, CoursesActivity::class.java)
//            startActivity(intent)
//        }
//
//    }
}







