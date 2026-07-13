package com.example.loginproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginproject.R
import com.example.loginproject.components.ButtonComponent
import com.example.loginproject.components.ClickableTextComponent
import com.example.loginproject.components.ErrorTextComponent
import com.example.loginproject.components.HeadingTextComponent
import com.example.loginproject.components.PasswordTextFieldComponent
import com.example.loginproject.components.PromptTextComponent
import com.example.loginproject.components.StandardTextFieldComponent
import com.example.loginproject.ui.theme.LoginProjectTheme
import com.example.loginproject.ui.theme.authGradientBrush

@Composable
internal fun LoginScreen(
    onSignUpClick: () -> Unit,
    onForgotPasswordClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val fillBothFieldsError = stringResource(R.string.error_fill_both_fields)
    val invalidEmailError = stringResource(R.string.error_invalid_email)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = authGradientBrush())
    ) {
        Column(modifier = Modifier.padding(horizontal = 28.dp, vertical = 40.dp)) {
            HeadingTextComponent(value = stringResource(R.string.heading_login_line1))
            HeadingTextComponent(value = stringResource(R.string.heading_login_line2))
        }

        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.82f),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            color = Color.White
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 28.dp)
                        .padding(top = 32.dp, bottom = 96.dp)
                ) {
                    Spacer(modifier = Modifier.height(28.dp))

                    StandardTextFieldComponent(
                        labelValue = stringResource(R.string.label_email),
                        value = email,
                        placeholderValue = stringResource(R.string.placeholder_email),
                        onValueChange = {
                            email = it
                            errorMessage = null
                        }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    PasswordTextFieldComponent(
                        labelValue = stringResource(R.string.label_password),
                        value = password,
                        onValueChange = {
                            password = it
                            errorMessage = null
                        }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        ClickableTextComponent(
                            value = stringResource(R.string.action_forgot_password),
                            onClick = onForgotPasswordClick
                        )
                    }

                    errorMessage?.let {
                        Spacer(modifier = Modifier.height(12.dp))
                        ErrorTextComponent(value = it)
                    }

                    Spacer(modifier = Modifier.height(64.dp))

                    ButtonComponent(value = stringResource(R.string.action_sign_in_button)) {
                        errorMessage = when {
                            email.isBlank() || password.isBlank() -> fillBothFieldsError
                            !email.contains("@") -> invalidEmailError
                            else -> null
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(horizontal = 28.dp, vertical = 32.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    PromptTextComponent(value = stringResource(R.string.prompt_no_account))
                    ClickableTextComponent(
                        value = stringResource(R.string.action_sign_up_link),
                        onClick = onSignUpClick
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginProjectTheme {
        LoginScreen(onSignUpClick = {})
    }
}