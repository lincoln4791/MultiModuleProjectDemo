package com.example.features.login.repository

import com.example.core.network.Post
import com.example.core.network.utils.GsonUtils
import com.example.features.login.datasource.LoginDataSourceImpl

class LoginRepositoryImpl(private val loginDataSource: LoginDataSourceImpl) : LoginRepository {
    override suspend fun getPosts(): List<Post> {
        return loginDataSource.getPosts()
    }
}