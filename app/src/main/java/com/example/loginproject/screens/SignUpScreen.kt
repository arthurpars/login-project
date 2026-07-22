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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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
import com.example.loginproject.viewmodel.SignUpError
import com.example.loginproject.viewmodel.SignUpViewModel

@Composable
internal fun SignUpScreen(
    onLoginClick: () -> Unit,
    viewModel: SignUpViewModel = viewModel()
) {
    val uiState = viewModel.uiState

    val errorMessage = when (uiState.error) {
        SignUpError.FillAllFields -> stringResource(R.string.error_fill_all_fields)
        SignUpError.InvalidEmail -> stringResource(R.string.error_invalid_email)
        SignUpError.PasswordMismatch -> stringResource(R.string.error_password_mismatch)
        else -> null
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = authGradientBrush())
    ) {
        Column(modifier = Modifier.padding(horizontal = 28.dp, vertical = 40.dp)) {
            HeadingTextComponent(value = stringResource(R.string.heading_signup_line1))
            HeadingTextComponent(value = stringResource(R.string.heading_signup_line2))
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
                    Spacer(modifier = Modifier.height(12.dp))

                    StandardTextFieldComponent(
                        labelValue = stringResource(R.string.label_name),
                        value = uiState.name,
                        placeholderValue = stringResource(R.string.placeholder_name),
                        onValueChange = viewModel::onNameChange
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    StandardTextFieldComponent(
                        labelValue = stringResource(R.string.label_signup_identifier),
                        value = uiState.email,
                        placeholderValue = stringResource(R.string.placeholder_email),
                        onValueChange = viewModel::onEmailChange
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    PasswordTextFieldComponent(
                        labelValue = stringResource(R.string.label_password),
                        value = uiState.password,
                        onValueChange = viewModel::onPasswordChange
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    PasswordTextFieldComponent(
                        labelValue = stringResource(R.string.label_confirm_password),
                        value = uiState.confirmPassword,
                        onValueChange = viewModel::onConfirmPasswordChange
                    )

                    errorMessage?.let {
                        Spacer(modifier = Modifier.height(12.dp))
                        ErrorTextComponent(value = it)
                    }

                    Spacer(modifier = Modifier.height(35.dp))

                    ButtonComponent(value = stringResource(R.string.action_sign_up_button)) {
                        viewModel.onSignUpClick()
                    }
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(horizontal = 28.dp, vertical = 32.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    PromptTextComponent(value = stringResource(R.string.prompt_have_account))
                    ClickableTextComponent(
                        value = stringResource(R.string.action_sign_in_link),
                        onClick = onLoginClick
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    LoginProjectTheme {
        SignUpScreen(onLoginClick = {})
    }
}