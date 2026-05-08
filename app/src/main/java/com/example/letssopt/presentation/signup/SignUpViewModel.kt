package com.example.letssopt.presentation.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.letssopt.common.util.isSignUpValid

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

    fun signUp(): Int {
        return isSignUpValid(
            email.value,
            password.value,
            passwordCheck.value
        )
    }
}