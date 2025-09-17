package com.example.features.login.repository

import com.example.core.network.Post

interface LoginRepository {

    suspend fun getPosts() : List<Post>;

}