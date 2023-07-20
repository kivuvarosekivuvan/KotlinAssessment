package com.rosekn.assessment.Repository

import com.rosekn.assessment.Api.ApiClient
import com.rosekn.assessment.Api.ApiInterface
import com.rosekn.assessment.Model.RegisterRequest
import com.rosekn.assessment.Model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient=ApiClient.buildClient(ApiInterface::class.java)

    suspend fun  registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> {
        return withContext(Dispatchers.IO){
            apiClient.registerUser(registerRequest)
        }
}}