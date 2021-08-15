package com.example.codehivdeprogram.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.codehivdeprogram.R
import com.example.codehivdeprogram.api.ApiClient
import com.example.codehivdeprogram.api.ApiInterface
import com.example.codehivdeprogram.databinding.ActivityLoginBinding
import com.example.codehivdeprogram.databinding.ActivityMainBinding
import com.example.codehivdeprogram.models.LoginRequest
import com.example.codehivdeprogram.models.LoginResponse
import com.example.codehivdeprogram.viewmodel.LoginViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val loginViewModel: LoginViewModel by viewModels()
    lateinit var sharedPreferences: SharedPreferences

}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("CODEHIVE_REG_PREFS", Context.MODE_PRIVATE)
        binding.btnLogIn.setOnClickListener {
            var logInRequest = LoginRequest(binding.etEmailLogIn.text.toString(),
                binding.etPasswordLogIn.text.toString())
            loginViewModel.logIn(loginRequest)
        }
    }

override fun onResume(){
    super.onResume()
    loginViewModel.logInLiveData.observe(this, { logInResponse->
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

//        setViews()
//        clickLogin()
//        lateinit var etEmail:EditText
//        lateinit var etpassword:EditText
//        lateinit var btnlogin:Button
//    }
//    fun setViews(){
//        etEmail=findViewById(R.id.etEmail)
//        etpassword=findViewById(R.id.etEmail)
//        btnlogin= findViewById(R.id.btnlogin)
//    }
//    fun clickLogin(){
//        var error= false
//        btnlogin.setOnClickListener {
//            var email= etEmail.text.toString()
//            if (email.isEmpty())
//                etEmail.setError("Email is required")
//        }
//        var password= etpassword.setOnClickListener {
//            var password= etpassword.text.toString()
//            if (password.isEmpty())
//                etpassword.setError("Fill this field")
//        }
//
//        var loginRequest= LoginRequest(
//            email= etEmail.text.toString(),
//            password=etpassword.text.toString()
//
//        )
//        btnlogin.setOnClickListener {
//            var intent = Intent(baseContext, CourseDetailsActivity::class.java)
//            startActivity(intent)
//
//            var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
//            var request = retrofit.loginStudent(loginRequest)
//            request.enqueue(object : Callback<LoginResponse?> {
//                override fun onResponse(
//                    call: Call<LoginResponse?>,
//                    response: Response<LoginResponse?>
//                ) {
//                    if (response.isSuccessful){
//                        Toast.makeText(baseContext,"You have logged in successfully",Toast.LENGTH_LONG
//                        ).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
//                  Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//                }
//            })
//        }
//    }

    }







