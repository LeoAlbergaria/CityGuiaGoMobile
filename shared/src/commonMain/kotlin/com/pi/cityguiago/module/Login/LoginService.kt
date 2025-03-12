package com.pi.cityguiago.module.Login

class LoginService {
    fun login(email: String, password: String): Boolean {
        return email == "test@mail.com" && password == "123"
    }
}