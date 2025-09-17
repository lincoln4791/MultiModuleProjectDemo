package com.example.features.login.datasource

import com.example.core.network.ApiService
import com.example.core.network.Post
import com.example.core.network.utils.GsonUtils

class LoginDataSourceImpl (private val api: ApiService) : LoginDataSource {

    override suspend fun getPosts(): List<Post> {
        val rawResponse = api.getPosts()
        return GsonUtils.convertToList(rawResponse, Post::class.java)
    }
}