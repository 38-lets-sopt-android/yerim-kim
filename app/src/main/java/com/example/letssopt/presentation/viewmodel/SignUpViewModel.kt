package com.example.letssopt.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    var email = mutableStateOf("")
        private set

    var password = mutableStateOf("")
        private set

    var passwordCheck = mutableStateOf("")
        private set

    fun updateEmail(input: String) {
        email.value = input
    }

    fun updatePassword(input: String) {
        password.value = input
    }

    fun updatePasswordCheck(input: String) {
        passwordCheck.value = input
    }
}