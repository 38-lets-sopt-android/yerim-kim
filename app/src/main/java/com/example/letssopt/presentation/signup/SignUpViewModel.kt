package com.example.letssopt.presentation.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.letssopt.common.util.isSignUpValid

class SignUpViewModel : ViewModel() {

    var userId = mutableStateOf("")
        private set

    var userPassword = mutableStateOf("")
        private set

    var userPasswordCheck = mutableStateOf("")
        private set

    var userName = mutableStateOf("")
        private set

    var userEmail = mutableStateOf("")
        private set

    var userAge = mutableStateOf("")
        private set

    var userPart = mutableStateOf("")
        private set

    fun updateId(input: String) {
        userId.value = input
    }

    fun updatePassword(input: String) {
        userPassword.value = input
    }

    fun updatePasswordCheck(input: String) {
        userPasswordCheck.value = input
    }

    fun updateName(input: String) {
        userName.value = input
    }

    fun updateEmail(input: String) {
        userEmail.value = input
    }

    fun updateAge(input: String) {
        userAge.value = input
    }

    fun updatePart(input: String) {
        userPart.value = input
    }

    fun signUp(): Int {
        return isSignUpValid(
            userEmail.value,
            userPassword.value,
            userPasswordCheck.value
        )
    }
}