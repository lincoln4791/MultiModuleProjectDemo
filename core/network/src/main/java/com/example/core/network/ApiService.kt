package com.example.core.network

import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Any
}
