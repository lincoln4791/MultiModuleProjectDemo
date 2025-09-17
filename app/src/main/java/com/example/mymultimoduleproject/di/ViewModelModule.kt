package com.example.mymultimoduleproject.di

import com.example.features.login.repository.LoginRepository
import com.example.features.login.repository.LoginRepositoryImpl
import com.example.features.login.viewmodel.LoginViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object ViewModelModule {

    @Provides
    fun provideLoginViewModel(loginRepository: LoginRepositoryImpl): LoginViewModel {
        return LoginViewModel(loginRepository)
    }
}
