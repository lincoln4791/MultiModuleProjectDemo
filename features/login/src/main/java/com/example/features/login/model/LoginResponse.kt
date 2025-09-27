package com.example.features.login.model
data class LoginResponse(
    val isSuccess : Boolean?=null,
    val id: Int?=null,
    val username: String?=null,
    val email: String?=null,
    val firstName: String?=null,
    val lastName: String?=null,
    val gender: String?=null,
    val image: String?=null,
    val token: String?=null
){

    companion object{
        fun demoResponseSuccess() : LoginResponse{
            return LoginResponse(
                isSuccess = true,
                id = 1,
                username = "johndoe",
                email = "johndoe@example.com",
                firstName = "John",
                lastName = "Doe",
                gender = "male",
                image = "https://example.com/avatar/johndoe.png",
                token = "fake_jwt_token_123456"
            )
        }
        fun demoResponseFail() : LoginResponse{
            return LoginResponse(
                isSuccess = false,
            )
        }
    }
}


