package com.example.features.login.repository

import com.example.core.network.LoginRequest
import com.example.core.network.Post
import com.example.myunittest.login.LoginResponse

interface LoginRepository {

    suspend fun login(loginRequest: LoginRequest) : LoginResponse;

}