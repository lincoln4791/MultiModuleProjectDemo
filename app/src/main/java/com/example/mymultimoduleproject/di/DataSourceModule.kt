package com.example.mymultimoduleproject.di
import com.example.core.network.AuthApiService
import com.example.features.login.datasource.LoginDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideLoginDataSource(authApiService: AuthApiService): LoginDataSourceImpl {
        return LoginDataSourceImpl(authApiService)
    }
}
