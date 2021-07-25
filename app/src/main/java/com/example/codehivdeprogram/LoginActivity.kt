package com.example.codehivdeprogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.codehivdeprogram.api.ApiClient
import com.example.codehivdeprogram.api.ApiInterface
import com.example.codehivdeprogram.models.LoginRequest
import com.example.codehivdeprogram.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var etEmail:EditText
    lateinit var etpassword:EditText
    lateinit var btnlogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setViews()
        clickLogin()
    }
    fun setViews(){
        etEmail=findViewById(R.id.etEmail)
        etpassword=findViewById(R.id.etEmail)
        btnlogin= findViewById(R.id.btnlogin)
    }
    fun clickLogin(){
        var error= false
        btnlogin.setOnClickListener {
            var email= etEmail.text.toString()
            if (email.isEmpty())
                etEmail.setError("Email is required")
        }
        var password= etpassword.setOnClickListener {
            var password= etpassword.text.toString()
            if (password.isEmpty())
                etpassword.setError("Fill this field")
        }

        var loginRequest= LoginRequest(
            email= etEmail.text.toString(),
            password=etpassword.text.toString()

        )
        btnlogin.setOnClickListener {
            var intent = Intent(baseContext, CourseDetailsActivity::class.java)
            startActivity(intent)

            var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.loginStudent(loginRequest)
            request.enqueue(object : Callback<LoginResponse?> {
                override fun onResponse(
                    call: Call<LoginResponse?>,
                    response: Response<LoginResponse?>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(baseContext,"You have logged in successfully",Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                  Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    }







