package com.example.mymultimoduleproject.di

import android.app.Application
import android.content.Context
import com.example.core.db.AppDatabase
import com.example.core.db.DatabaseProvider
import com.example.core.db.UserDao
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
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): AuthApiService {
        // Call your existing NetworkModule function
        return NetworkModule.provideAuthApi()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return DatabaseProvider.getDatabase(context)
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()
}
