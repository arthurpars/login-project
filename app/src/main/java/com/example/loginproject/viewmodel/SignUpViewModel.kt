package com.example.loginproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class SignUpUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val errorMessage: String? = null
)

class SignUpViewModel : ViewModel() {

    var uiState by mutableStateOf(SignUpUiState())
        private set

    fun onNameChange(newName: String) {
        uiState = uiState.copy(name = newName, errorMessage = null)
    }

    fun onEmailChange(newEmail: String) {
        uiState = uiState.copy(email = newEmail, errorMessage = null)
    }

    fun onPasswordChange(newPassword: String) {
        uiState = uiState.copy(password = newPassword, errorMessage = null)
    }

    fun onConfirmPasswordChange(newConfirmPassword: String) {
        uiState = uiState.copy(confirmPassword = newConfirmPassword, errorMessage = null)
    }

    fun onSignUpClick(
        fillAllFieldsError: String,
        invalidEmailError: String,
        passwordMismatchError: String
    ) {
        uiState = uiState.copy(
            errorMessage = when {
                uiState.name.isBlank() || uiState.email.isBlank() || uiState.password.isBlank() ->
                    fillAllFieldsError

                !uiState.email.contains("@") -> invalidEmailError
                uiState.password != uiState.confirmPassword -> passwordMismatchError
                else -> null
            }
        )
    }
}