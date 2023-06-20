package com.rosekn.assessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rosekn.assessment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        validatePage()


        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }

    fun validatePage(): Boolean {
        val username = binding.etuser.text.toString().capitalize()
        val email = binding.etemail.text.toString()
        val phone = binding.etphone.text.toString()
        val password = binding.etpassword.text.toString()
        var error = false
        clearErrors()


        if (username.isBlank()) {
            binding.etuser.error = "user name is required"
            error = true
        }


        if (email.isBlank()) {
            binding.etemail.error = "email name is required"
            error = true
        }

        if (phone.isBlank()) {
            binding.etphone.error = "Contact is required"
            error = true
        }

        if (email.isBlank()) {
            binding.etemail.error = "Email is required"
            error = true
        }


        return email.isNotBlank() && username.isNotBlank() && phone.isNotBlank() && email.isNotBlank() && password.isNotBlank()
    }

    fun clearErrors() {
        binding.etemail.error = null
        binding.etphone.error = null
        binding.etpassword.error = null
        binding.etemail.error = null
    }
}
