package com.example.letssopt.presentation.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val success: Boolean,
    val status: Int,
    val message: String,
    val code: String,
    val data: LoginData? = null
)

@Serializable
data class LoginData(
    val userId: Int
)