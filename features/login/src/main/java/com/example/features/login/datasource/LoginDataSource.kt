package com.example.features.login.datasource

interface LoginDataSource {

    suspend fun getPosts() : Any;

}