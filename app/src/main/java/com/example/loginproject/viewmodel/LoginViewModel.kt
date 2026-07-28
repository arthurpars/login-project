package com.example.loginproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.loginproject.validation.EmailValidator

sealed interface LoginError {
    data object FillBothFields : LoginError
    data object InvalidEmail : LoginError
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val error: LoginError? = null
)

class LoginViewModel(private val emailValidator: EmailValidator) : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(newEmail: String) {
        uiState = uiState.copy(email = newEmail, error = null)
    }

    fun onPasswordChange(newPassword: String) {
        uiState = uiState.copy(password = newPassword, error = null)
    }

    fun onLoginClick() {
        uiState = uiState.copy(error = validate(uiState))
    }

    private fun validate(state: LoginUiState): LoginError? = when {
        state.email.isBlank() || state.password.isBlank() -> LoginError.FillBothFields
        !emailValidator.isValid(state.email) -> LoginError.InvalidEmail
        else -> null
    }
}
