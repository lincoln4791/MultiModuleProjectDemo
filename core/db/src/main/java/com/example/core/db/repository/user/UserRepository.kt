package com.example.core.db.repository.user

import com.example.core.db.entity.UserEntity

interface UserRepository {
    suspend fun insertUser(user: UserEntity)

    suspend fun getUsers(): List<UserEntity>
}