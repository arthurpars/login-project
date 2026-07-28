package com.example.loginproject.validation

class PasswordValidator {
    fun isValid(password: String): Boolean = password.length >= MIN_LENGTH

    private companion object {
        const val MIN_LENGTH = 8
    }
}