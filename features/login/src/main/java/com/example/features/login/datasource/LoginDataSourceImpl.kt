package com.example.features.login.datasource

import com.example.core.network.AuthApiService
import com.example.core.network.LoginRequest
import com.example.core.network.Post
import com.example.core.network.utils.GsonUtils
import com.example.myunittest.login.LoginResponse

class LoginDataSourceImpl (private val api: AuthApiService) : LoginDataSource {

    override suspend fun login(loginRequest : LoginRequest): LoginResponse {
        val rawResponse = api.login(loginRequest)
        return GsonUtils.convertToObject(rawResponse, LoginResponse::class.java)
    }
}