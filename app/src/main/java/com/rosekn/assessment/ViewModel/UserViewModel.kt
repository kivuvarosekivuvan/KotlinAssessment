//package com.rosekn.assessment.ViewModel
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.rosekn.assessment.Model.RegisterRequest
//import com.rosekn.assessment.Model.RegisterResponse
//import com.rosekn.assessment.Repository.UserRepository
//import kotlinx.coroutines.launch
//
//class UserViewModel:ViewModel() {
//    val userRepository=UserRepository()
//    val regLiveData=MutableLiveData<RegisterResponse>()
//    val errLiveData = MutableLiveData<String>()
//
//    fun registerUser(registerRequest: RegisterRequest){
//        viewModelScope.launch {
//            val response = userRepository.registerUser()
//            if(response.isSuccessful){
//                regLiveData.postValue(response.body())
//            }else{
//                errLiveData.postValue(response.errorBody()?.string())
//            }
//        }
//    }
//}

package com.rosekn.assessment.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rosekn.assessment.Model.RegisterRequest
import com.rosekn.assessment.Model.RegisterResponse
import com.rosekn.assessment.Repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel : ViewModel() {
    private val userRepository = UserRepository()
    private val _regLiveData = MutableLiveData<RegisterResponse>()
    val regLiveData: LiveData<RegisterResponse> get() = _regLiveData
    private val _errLiveData = MutableLiveData<String>()
    val errLiveData: LiveData<String> get() = _errLiveData

    fun registerUser(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            val response = userRepository.registerUser(registerRequest)
            if (response.isSuccessful) {
                _regLiveData.postValue(response.body())
            } else {
                _errLiveData.postValue(response.errorBody()?.string() ?: "Unknown error")
            }
        }
    }
}
