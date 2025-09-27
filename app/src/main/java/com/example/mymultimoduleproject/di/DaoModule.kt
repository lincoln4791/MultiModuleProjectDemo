package com.example.mymultimoduleproject.di

import android.app.Application
import android.content.Context
import com.example.core.db.AppDatabase
import com.example.core.db.DatabaseProvider
import com.example.core.db.dao.ProductDao
import com.example.core.db.dao.UserDao
import com.example.core.network.AuthApiService
import com.example.core.network.NetworkModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideProductDao(db: AppDatabase): ProductDao = db.productDao()

}
