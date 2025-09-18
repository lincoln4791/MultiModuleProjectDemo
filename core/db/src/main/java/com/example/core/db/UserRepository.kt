package com.example.core.db

class UserRepository(private val db: AppDatabase) {

    suspend fun insertUser(user: UserEntity) {
        db.userDao().insert(user)
    }

    suspend fun getUsers(): List<UserEntity> {
        return db.userDao().getAllUser()
    }
}
