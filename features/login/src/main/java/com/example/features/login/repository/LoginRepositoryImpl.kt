package com.example.features.login.repository

import com.example.core.network.LoginRequest
import com.example.features.login.datasource.LoginDataSourceImpl
import com.example.features.login.model.LoginResponse

class LoginRepositoryImpl(private val loginDataSource: LoginDataSourceImpl) : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return loginDataSource.login(loginRequest)
    }
}