package com.example.mymultimoduleproject.di

import com.example.core.db.repository.product.ProductRepositoryImpl
import com.example.core.db.repository.user.UserRepositoryImpl
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
    fun provideLoginViewModel(loginRepository: LoginRepositoryImpl,userRepo : UserRepositoryImpl, productRepositoryImpl: ProductRepositoryImpl): LoginViewModel {
        return LoginViewModel(loginRepository,userRepo,productRepositoryImpl)
    }
}
