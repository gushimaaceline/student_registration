package com.example.codehivdeprogram.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import com.example.codehivdeprogram.R
import com.example.codehivdeprogram.api.ApiClient
import com.example.codehivdeprogram.api.ApiInterface
import com.example.codehivdeprogram.databinding.ActivityMainBinding
import com.example.codehivdeprogram.models.RegistrationResponse
import com.example.codehivdeprogram.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.codehivdeprogram.models.RegistrationRequest as RegistrationRequest

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var nationality= arrayOf("Rwandan","Ugandan","Kenyan","South Sudan")
        var nationalityAdapter= ArrayAdapter(baseContext,android.R.layout.simple_spinner_item,nationality)
        binding.spNationality.adapter= nationalityAdapter
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.btnLogin.SetOnClickListner{
            var intent= Intent(baseContext,LoginActivity::class.java)
            startActivity(intent)
        }
                
        }

    }

    override fun onResume(){
        super.onResume()
        binding.btnRegister.setOnClickListener {

            if(binding. etname.text.toString().isEmpty()||
                binding.etdob.text.toString().isEmpty()||
                binding.etmail.text.toString().isEmpty()||
                binding.etpassword.text.toString().isEmpty()||
                binding.etPhone.text.toString().isEmpty()
            ){
                binding.etname.setError("Name is required")
                binding.etdob.setError("Date of birth is required")
                binding.etmail.setError("Email is required")
                binding.etpassword.setError("Date is required")
                binding.etPhone.setError("Phone number is required")
            }
            var name= binding.etname.text.toString()
            var dob= binding.etdob.text.toString()
            var email= binding.etmail.text.toString()
            var password= binding.etpassword.text.toString()
            var phone= binding.etPhone.text.toString()

            var regRequest= RegistrationRequest(
                name= binding.etname.text.toString()
                dob= binding.etdob.text.toString()
                email= binding.etmail.text.toString()
                password= binding.etpassword.text.toString()
                phoneNumber= binding.etPhone.text.toString()
                nationality= binding.spNationality.selectItem.toString().uppercase()

            )
            var intent= Intent(baseContext, LoginActivity ::class.java)
            startActivity(intent)

            userViewModel.registrationStudent(regRequest)
        }
        userViewModel.regFailedLiveData.observe(this, { regResponse ->
            if (!regResponse.studentId isNullOrEmpty()){
                Toast.makeText(baseContext,"Registration Successfull",
                    Toast.LENGTH_LONG).show()
                
        })
            userViewModel.regFailedLiveData.observe(this, { error ->
                Toast.makeText(baseContext, "error", Toast.LENGTH_LONG).show()

            })

        }
    }



//        castViews()
//        clickRegister()

//    lateinit var etName: EditText
//    lateinit var etDob: EditText
//    lateinit var spNationality: Spinner
//    lateinit var etPhoneNumber: EditText
//    lateinit var etEmail: EditText
//    lateinit var btnRegister: Button
//    lateinit var etPassword: EditText



//    fun castViews(){
//        etName = findViewById(R.id.etName)
//        etDob  = findViewById(R.id.etDob)
//        spNationality = findViewById(R.id.spNationality)
//        etEmail = findViewById(R.id.etEmail)
//        etPhoneNumber = findViewById(R.id.etPhoneNumber)
//        btnRegister = findViewById(R.id.btnRegister)
//        etPassword = findViewById(R.id.etPassword)

//        val nationality = arrayOf("Kenyan", "Ugandan", "Rwandese", "South Sudanes")
//        var nationalityAdapter = ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationality)
//        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spNationality.adapter = nationalityAdapter
//
//    }
//    fun clickRegister(){
//        var error = false
//        btnRegister.setOnClickListener {
//            var name = etName.text.toString()
//            if (name.isEmpty()) {
//                error = true
//                etName.setError("Name is required")
//            }

//            var dob = etDob.text.toString()
//            if (dob.isEmpty()) {
//                error = true
//                etDob.setError("Date of birth is required")
//            }
//
//            var tilPassword = etPassword.text.toString()
//            if (tilPassword.isEmpty()) {
//                error = true
//                etPassword.setError("Input password")
//            }
//
//            var nationality = spNationality.selectedItem.toString()
//
//            var email = etEmail.text.toString()
//            if (email.isEmpty()) {
//                error = true
//                etEmail.setError("Email required")
//            }
//
//            var phoneNumber = etPhoneNumber.text.toString()
//            if (phoneNumber.isEmpty()) {
//                error = true
//                etPhoneNumber.setError("Input phone number")
//            }
//
//            var registrationRequest = RegistrationRequest(
//                name = name,
//                phoneNumber = phoneNumber,
//                email = email,
//                dateOfBirth = dob,
//                password = tilPassword
//            )
//
//            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
//            var request = retrofit.registerStudent(registrationRequest)
//            request.enqueue(object : Callback<RegistrationResponse> {
//
//                override fun onResponse(
//                    call: Call<RegistrationResponse>,
//                    response: Response<RegistrationResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG)
//                            .show()
//                    }
//                }
//
//                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
//                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//                }
//
//            })
//            val intent = Intent(baseContext, LogIn::class.java)
//            startActivity(intent)
//        }
//
