package com.example.loginproject.validation

class EmailValidator {
    fun isValid(email: String): Boolean {
        val atIndex = email.indexOf("@")
        if (atIndex <= 0) return false
        val domain = email.substring(atIndex + 1)
        return domain.contains(".") && !domain.startsWith(".") && !domain.endsWith(".")
    }
}
