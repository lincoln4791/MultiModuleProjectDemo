package com.example.features.login.viewmodel

import com.example.core.db.UserRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.db.UserEntity
import com.example.core.network.LoginRequest
import com.example.features.login.repository.LoginRepositoryImpl
import com.example.myunittest.login.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: LoginRepositoryImpl,private val userRepository: UserRepository) : ViewModel() {

    fun doLogin(username : String,password:String,onResult: (LoginResponse) -> Unit) {
        viewModelScope.launch {
            val message = repo.login(LoginRequest(username,password))
            onResult(message)
        }
    }


    fun insertTestDataInRoom(){
        viewModelScope.launch {
            userRepository.insertUser(UserEntity((1..1000).random(),"a","v"))
        }
    }
}