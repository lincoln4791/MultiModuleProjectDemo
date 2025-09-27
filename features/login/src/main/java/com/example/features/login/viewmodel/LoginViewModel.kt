package com.example.features.login.viewmodel

import com.example.core.db.repository.user.UserRepositoryImpl
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.db.entity.ProductEntity
import com.example.core.db.entity.UserEntity
import com.example.core.db.repository.product.ProductRepositoryImpl
import com.example.core.network.LoginRequest
import com.example.features.login.repository.LoginRepositoryImpl
import com.example.features.login.model.LoginResponse
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: LoginRepositoryImpl,private val userRepositoryImpl: UserRepositoryImpl,private val productRepositoryImpl: ProductRepositoryImpl) : ViewModel() {

    fun doLogin(username : String,password:String,onResult: (LoginResponse) -> Unit) {
        viewModelScope.launch {
            val message = repo.login(LoginRequest(username,password))
            onResult(message)
        }
    }


    fun insertTestDataInRoom(){
        viewModelScope.launch {
            userRepositoryImpl.insertUser(UserEntity((1..1000).random(),"a","v"))
        }
    }

    fun insertProductDataInRoom(){
        viewModelScope.launch {
            productRepositoryImpl.insertProduct(ProductEntity("gg","wp"))
        }
    }
}