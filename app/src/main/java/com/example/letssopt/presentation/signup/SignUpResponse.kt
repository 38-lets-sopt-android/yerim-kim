package com.example.letssopt.presentation.signup

import kotlinx.serialization.Serializable

@Serializable
data class SignUpResponse(
    val success: Boolean,
    val status: Int,
    val message: String,
    val code: String
)