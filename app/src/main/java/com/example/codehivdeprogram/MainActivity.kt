package com.example.codehivdeprogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.codehivdeprogram.api.ApiClient
import com.example.codehivdeprogram.api.ApiInterface
import com.example.codehivdeprogram.models.RegistrationResponse
import retrofit2.Call
import retrofit2.Response
import com.example.codehivdeprogram.models.RegistrationRequest as RegistrationRequest

class MainActivity : AppCompatActivity() {
    lateinit var etname: EditText
    lateinit var etmail: EditText
    lateinit var etdob: EditText
    lateinit var spNationality: Spinner
    lateinit var etPassword: EditText
    lateinit var etphone: EditText
    lateinit var btnRegister:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        clickRegister()
    }
    fun castViews(){
        etname= findViewById(R.id.etname)
        etdob= findViewById(R.id.etdob)
        etmail= findViewById(R.id.etmail)
        etPassword= findViewById(R.id.etpassword)
        spNationality= findViewById(R.id.spNationality)
        etphone= findViewById(R.id.etPhone)
        btnRegister= findViewById(R.id.btnRegister)

        var nationality= arrayOf("Rwandan","Ugandan","Kenyan","South Sudan")
        var nationalityAdapter= ArrayAdapter<String>(baseContext,android.R.layout.simple_spinner_item,nationality)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spNationality.adapter= nationalityAdapter
    }
    fun clickRegister(){
        btnRegister.setOnClickListener {
            var name= etname.text.toString()
            if(name.isEmpty()){
                etname.setError("Name is required")
            }
            var dob= etdob.text.toString()
            if(dob.isEmpty()){
                etdob.setError("Date is required")
            }
            var email= etmail.text.toString()
            if (email.isEmpty()){
                etmail.setError("Email is required")
            }
            var password= etPassword.text.toString()
            if (password.isEmpty()){
                etPassword.setError("Identiy is required")
            }
            var phone= etphone.text.toString()
            if (phone.isEmpty()){
                etphone.setError("Phone Number is required")

            }
//
//
            var nationality= spNationality.selectedItem.toString()
            if(nationality.isEmpty()){
                spNationality.dropDownVerticalOffset
            }

            var registrationRequest= RegistrationRequest(
                name =name, phoneNumber =phone, email = email, nationality = nationality,
                dateOfBirth =dob, password = password
            )
            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request= retrofit.registerStudent(registrationRequest)
            request.enqueue(object : retrofit2.Callback<RegistrationResponse> {
                override fun onResponse(
                    call: Call<RegistrationResponse>,
                    response: Response<RegistrationResponse>
                ) {
                   if (response.isSuccessful)
                       Toast.makeText(baseContext,"Registration Successfull",
                           Toast.LENGTH_LONG).show()
                    var intent= Intent(baseContext,LoginActivity ::class.java)
                    startActivity(intent)
                }

                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                    Toast.makeText(baseContext,t.message,
                        Toast.LENGTH_LONG).show()
                }


        })
    }
}



}
