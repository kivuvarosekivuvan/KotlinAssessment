package com.rosekn.assessment.Model

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("phone_number")val phone : String,
    @SerializedName("first_name") val username : String,
   @SerializedName("last_name")val second :String,
  val email :String,
    val password :String,
)
