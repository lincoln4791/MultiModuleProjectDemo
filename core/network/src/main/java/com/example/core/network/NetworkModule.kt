package com.example.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    fun provideAuthApi(): AuthApiService {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApiService::class.java)
    }
}
