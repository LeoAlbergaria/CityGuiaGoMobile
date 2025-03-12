package com.pi.cityguiago.module.Register

import com.pi.cityguiago.model.AuthResponse
import com.pi.cityguiago.model.SignupRequest
import com.pi.cityguiago.network.ApiClient

class RegisterService() {
    private val apiClient: ApiClient = ApiClient()
    suspend fun register(nome: String, email: String, password: String): Result<AuthResponse> {
        val result: Result<AuthResponse> = apiClient.post("https://cityguiago.com/api/auth/register/", SignupRequest(nome, email, password))

        result.onSuccess {
        }

        return result
    }
}