package com.example.letssopt.presentation.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.data.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.json.JSONObject

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

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login() = viewModelScope.launch {
        if (id.value.isBlank() || password.value.isBlank()) {
            _uiState.value = LoginUiState.Error("아이디와 비밀번호를 입력해주세요.")
            return@launch
        }
        _uiState.value = LoginUiState.Loading

        runCatching {
            RetrofitClient.apiService.login(
                LoginRequest(
                    loginId = id.value,
                    password = password.value
                )
            )
        }.onSuccess { response ->
            if (response.isSuccessful) {
                _uiState.value = LoginUiState.Success
            } else {
                val errorBody = response.errorBody()?.string()

                val message = try {
                    JSONObject(errorBody ?: "").getString("message")
                } catch (e: Exception) {
                    "로그인에 실패했습니다."
                }

                _uiState.value = LoginUiState.Error(message)
            }
        }.onFailure { e ->
            val message = e.message
                .takeUnless { it.isNullOrBlank() }
                ?: "네트워크 오류가 발생했습니다."

            _uiState.value = LoginUiState.Error(message)
        }
    }

    fun resetState() {
        _uiState.value = LoginUiState.Idle
    }

    sealed class LoginUiState {
        object Idle : LoginUiState()
        object Loading : LoginUiState()
        object Success : LoginUiState()
        data class Error(val message: String) : LoginUiState()
    }

//    fun login(): Int {
//        return isLoginValid(
//            id.value,
//            password.value
//        )
//    }
}