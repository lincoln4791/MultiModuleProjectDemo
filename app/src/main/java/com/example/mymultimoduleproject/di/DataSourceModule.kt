package com.example.mymultimoduleproject.di
import com.example.core.network.ApiService
import com.example.features.login.datasource.LoginDataSource
import com.example.features.login.datasource.LoginDataSourceImpl
import com.example.features.login.repository.LoginRepository
import com.example.features.login.repository.LoginRepositoryImpl
import dagger.Binds
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
    fun provideLoginDataSource(apiService: ApiService): LoginDataSourceImpl {
        return LoginDataSourceImpl(apiService)
    }

}
