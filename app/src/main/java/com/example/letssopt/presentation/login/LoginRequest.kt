package com.example.letssopt.presentation.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val loginId: String,
    val password: String
)