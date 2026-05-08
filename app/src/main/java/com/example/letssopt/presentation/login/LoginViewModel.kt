package com.example.letssopt.presentation.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.letssopt.common.util.isLoginValid

class LoginViewModel : ViewModel() {
    var id = mutableStateOf("")
        private set

    var password = mutableStateOf("")
        private set

    fun updateId(input: String) {
        id.value = input
    }

    fun updatePassword(input: String) {
        password.value = input
    }

    fun login(
        savedEmail: String?,
        savedPassword: String?
    ): Int {
        return isLoginValid(
            id.value,
            password.value,
            savedEmail,
            savedPassword
        )
    }
}