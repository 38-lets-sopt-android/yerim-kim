package com.example.letssopt.presentation.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.R
import com.example.letssopt.common.util.isSignUpValid
import com.example.letssopt.data.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

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

    private val _uiState = MutableStateFlow<SignUpUiState>(SignUpUiState.Idle)
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    fun signUp(
        loginId: String,
        password: String,
        name: String,
        email: String,
        age: String,
        part: String
    ) = viewModelScope.launch {

        val validationResult = isSignUpValid(
            id = userId.value,
            password = userPassword.value,
            passwordCheck = userPasswordCheck.value,
            name = userName.value,
            email = userEmail.value,
            age = userAge.value,
            part = userPart.value
        )

        if (validationResult != R.string.succeed_signup) {
            _uiState.value = SignUpUiState.ErrorInput(validationResult)
            return@launch
        }

        _uiState.value = SignUpUiState.Loading

        runCatching {
            RetrofitClient.apiService.signUp(
                SignUpRequest(loginId, password, name, email, age.toInt(), part)
            )
        }.onSuccess { response ->
            if (response.isSuccessful) {
                _uiState.value = SignUpUiState.Success
            } else {
                val message = response.errorBody()?.string()
                    .takeUnless { it.isNullOrBlank() }
                    ?: "회원가입에 실패했습니다"

                _uiState.value = SignUpUiState.Error(message)
            }
        }.onFailure { e ->
            val message = e.message
                .takeUnless { it.isNullOrBlank() }
                ?: "네트워크 오류가 발생했습니다"

            _uiState.value = SignUpUiState.Error(message)
        }
    }

    fun resetState() {
        _uiState.value = SignUpUiState.Idle
    }

    sealed class SignUpUiState {
        object Idle : SignUpUiState()
        object Loading : SignUpUiState()
        object Success : SignUpUiState()
        data class Error(val message: String) : SignUpUiState()
        data class ErrorInput(val message: Int) : SignUpUiState()
    }
}