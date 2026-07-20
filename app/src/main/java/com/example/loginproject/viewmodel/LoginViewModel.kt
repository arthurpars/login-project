package com.example.loginproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val errorMessage: String? = null
)

class LoginViewModel : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(newEmail: String) {
        uiState = uiState.copy(email = newEmail, errorMessage = null)
    }

    fun onPasswordChange(newPassword: String) {
        uiState = uiState.copy(password = newPassword, errorMessage = null)
    }

    fun onLoginClick(fillBothFieldsError: String, invalidEmailError: String) {
        uiState = uiState.copy(
            errorMessage = when {
                uiState.email.isBlank() || uiState.password.isBlank() -> fillBothFieldsError
                !uiState.email.contains("@") -> invalidEmailError
                else -> null
            }
        )
    }
}