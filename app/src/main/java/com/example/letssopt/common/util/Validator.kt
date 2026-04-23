package com.example.letssopt.common.util

import com.example.letssopt.R
import java.util.regex.Pattern

fun isEmailValid(email: String): Boolean {
    val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)

    return pattern.matcher(email).matches()
}

fun isSignUpValid(
    email: String,
    password: String,
    passwordCheck: String
): Int {
    return when {
        email.isEmpty() || password.isEmpty() || passwordCheck.isEmpty() -> R.string.empty_signup
        !isEmailValid(email) -> R.string.invalid_email
        password.length < 8 -> R.string.password_too_short
        password.length > 12 -> R.string.password_too_long
        passwordCheck != password -> R.string.password_mismatch
        else -> R.string.succeed_signup
    }
}

fun isLoginValid(
    email: String,
    password: String,
    savedEmail: String?,
    savedPassword: String?
): Int {
    return when {
        savedEmail == null || savedPassword == null -> R.string.empty_login
        email == savedEmail && password == savedPassword -> R.string.succeed_login
        else -> R.string.fail_login
    }
}