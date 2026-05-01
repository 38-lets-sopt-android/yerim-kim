package com.example.letssopt.presentation.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.letssopt.common.util.isLoginValid

class LoginViewModel : ViewModel() {
    var email = mutableStateOf("")
        private set

    var password = mutableStateOf("")
        private set

    fun updateEmail(input: String) {
        email.value = input
    }

    fun updatePassword(input: String) {
        password.value = input
    }

    fun login(
        savedEmail: String?,
        savedPassword: String?
    ): Int {
        return isLoginValid(
            email.value,
            password.value,
            savedEmail,
            savedPassword
        )
    }
}