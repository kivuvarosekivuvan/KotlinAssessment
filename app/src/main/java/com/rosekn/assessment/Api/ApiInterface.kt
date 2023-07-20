package com.rosekn.assessment.Api

import com.rosekn.assessment.Model.RegisterRequest
import com.rosekn.assessment.Model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>

}