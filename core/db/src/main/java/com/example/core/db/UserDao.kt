package com.example.core.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: Int): UserEntity?

    @Query("SELECT * FROM users")
    suspend fun getAllUser(): List<UserEntity>
}
