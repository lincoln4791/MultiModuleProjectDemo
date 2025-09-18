package com.example.core.network

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Any
}
