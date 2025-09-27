package com.example.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.db.dao.ProductDao
import com.example.core.db.dao.UserDao
import com.example.core.db.entity.ProductEntity
import com.example.core.db.entity.UserEntity

@Database(entities = [UserEntity::class, ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao
}
