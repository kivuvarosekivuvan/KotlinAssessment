package com.rosekn.assessment.Api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.37.106.218")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun<T>buildClient(apiInterface: Class<T>):T{
        return retrofit.create(apiInterface)
    }
}