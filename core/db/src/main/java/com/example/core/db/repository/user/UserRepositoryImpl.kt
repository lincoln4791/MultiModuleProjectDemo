package com.example.core.db.repository.user

import com.example.core.db.AppDatabase
import com.example.core.db.entity.UserEntity

class UserRepositoryImpl(private val db: AppDatabase) : UserRepository {

    override suspend fun insertUser(user: UserEntity) {
        db.userDao().insert(user)
    }

    override suspend fun getUsers(): List<UserEntity> {
        return db.userDao().getAllUser()
    }
}