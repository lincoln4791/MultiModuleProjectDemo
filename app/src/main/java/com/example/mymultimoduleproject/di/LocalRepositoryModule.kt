package com.example.mymultimoduleproject.di
import com.example.core.db.repository.user.UserRepositoryImpl
import com.example.core.db.AppDatabase
import com.example.core.db.repository.product.ProductRepositoryImpl
import com.example.features.login.datasource.LoginDataSourceImpl
import com.example.features.login.repository.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 object LocalRepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(appDatabase : AppDatabase) : UserRepositoryImpl {
        return UserRepositoryImpl(appDatabase)
    }

    @Provides
    @Singleton
    fun provideProductRepository(appDatabase : AppDatabase) : ProductRepositoryImpl {
        return ProductRepositoryImpl(appDatabase)
    }

}
