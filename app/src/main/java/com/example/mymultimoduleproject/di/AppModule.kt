package com.example.mymultimoduleproject.di

import com.example.core.network.ApiService
import com.example.core.network.NetworkModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        // Call your existing NetworkModule function
        return NetworkModule.provideApi()
    }
}
