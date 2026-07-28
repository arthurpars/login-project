package com.example.loginproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.loginproject.validation.EmailValidator
import com.example.loginproject.validation.PasswordValidator

sealed interface SignUpError {
    data object FillAllFields : SignUpError
    data object InvalidEmail : SignUpError
    data object WeakPassword : SignUpError
    data object PasswordMismatch : SignUpError
}

data class SignUpUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val error: SignUpError? = null
)

class SignUpViewModel(
    private val emailValidator: EmailValidator,
    private val passwordValidator: PasswordValidator
) : ViewModel() {

    var uiState by mutableStateOf(SignUpUiState())
        private set

    fun onNameChange(newName: String) {
        uiState = uiState.copy(name = newName, error = null)
    }

    fun onEmailChange(newEmail: String) {
        uiState = uiState.copy(email = newEmail, error = null)
    }

    fun onPasswordChange(newPassword: String) {
        uiState = uiState.copy(password = newPassword, error = null)
    }

    fun onConfirmPasswordChange(newConfirmPassword: String) {
        uiState = uiState.copy(confirmPassword = newConfirmPassword, error = null)
    }

    fun onSignUpClick() {
        uiState = uiState.copy(error = validate(uiState))
    }

    private fun validate(state: SignUpUiState): SignUpError? = when {
        state.name.isBlank() ||
                state.email.isBlank() ||
                state.password.isBlank() ||
                state.confirmPassword.isBlank() -> SignUpError.FillAllFields

        !emailValidator.isValid(state.email) -> SignUpError.InvalidEmail
        !passwordValidator.isValid(state.password) -> SignUpError.WeakPassword
        state.password != state.confirmPassword -> SignUpError.PasswordMismatch
        else -> null
    }
}
