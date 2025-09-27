package com.example.features.login.repository

import com.example.core.network.LoginRequest
import com.example.features.login.model.LoginResponse

interface LoginRepository {

    suspend fun login(loginRequest: LoginRequest) : LoginResponse;

}