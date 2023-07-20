package com.rosekn.assessment.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.rosekn.assessment.Login
import com.rosekn.assessment.Model.RegisterRequest
import com.rosekn.assessment.ViewModel.UserViewModel
import com.rosekn.assessment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        binding.btnRegister.setOnClickListener {
            validatePage()
        }
            binding.btnLogin.setOnClickListener {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)

            }



        userViewModel.errLiveData.observe(this) { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
            binding.pgRegister.visibility= View.VISIBLE

        }


//        userViewModel.regLiveData.observe(this) { regResponse ->
//            Toast.makeText(this, regResponse, Toast.LENGTH_LONG).show()
//            startActivity(Intent(this, Login::class.java))
//        }
        userViewModel.regLiveData.observe(this) { regResponse ->
            binding.pgRegister.visibility= View.VISIBLE
            Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, Login::class.java))
        }


    }

    fun validatePage() {
        val username = binding.etuser.text.toString().capitalize()
        val second = binding.etSecond.text.toString().capitalize()
        val email = binding.etemail.text.toString()
        val phone = binding.etphone.text.toString()
        val password = binding.etpassword.text.toString()
        val confirm = binding.etConfirm.text.toString()
        var error = false


        if (username.isBlank()) {
            binding.tiluser.error = "user name is required"
            error = true
        }
        if (second.isBlank()) {
            binding.etSecond.error = "last name is required"
            error = true
        }


        if (email.isBlank()) {
            binding.tilemail.error = "email name is required"
            error = true
        }

        if (phone.isBlank()) {
            binding.tilphone.error = "Contact is required"
            error = true
        }

        if (password.isBlank()) {
            binding.tilpassword.error = "password is required"
            error = true
        }
        if (confirm.isBlank()) {
            binding.tilConfirm.error = " Confirm password is required"
            error = true
        }

        if (!error) {
            val registerRequest = RegisterRequest(
                username = username,
                second = second,
                email = email,
                password = password,
                phone = phone


            )
            binding.pgRegister.visibility= View.VISIBLE
            userViewModel.registerUser(registerRequest)
        }
    }
}





