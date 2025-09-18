package com.example.features.login.datasource

import com.example.core.network.LoginRequest

interface LoginDataSource {

    suspend fun login(loginRequest: LoginRequest) : Any;

}