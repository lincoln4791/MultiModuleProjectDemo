package com.example.features.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.network.Post
import com.example.features.login.repository.LoginRepositoryImpl
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: LoginRepositoryImpl) : ViewModel() {

    fun doLogin(onResult: (List<Post>) -> Unit) {
        viewModelScope.launch {
            val message = repo.getPosts()
            onResult(message)
        }
    }
}