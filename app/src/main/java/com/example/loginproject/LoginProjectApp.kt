package com.example.loginproject

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.loginproject.screens.LoginScreen
import com.example.loginproject.screens.SignUpScreen
import com.example.loginproject.screens.WelcomeScreen

private enum class AuthScreen { WELCOME, LOGIN, SIGN_UP }

@Composable
internal fun LoginProjectApp() {
    var screen by rememberSaveable { mutableStateOf(AuthScreen.WELCOME) }

    when (screen) {
        AuthScreen.WELCOME -> WelcomeScreen(
            onSignInClick = { screen = AuthScreen.LOGIN },
            onSignUpClick = { screen = AuthScreen.SIGN_UP })

        AuthScreen.LOGIN -> LoginScreen(onSignUpClick = { screen = AuthScreen.SIGN_UP })

        AuthScreen.SIGN_UP -> SignUpScreen(onLoginClick = { screen = AuthScreen.LOGIN })
    }
}
