package com.example.loginproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginproject.R
import com.example.loginproject.components.ButtonComponent
import com.example.loginproject.components.ErrorTextComponent
import com.example.loginproject.components.HeadingTextComponent
import com.example.loginproject.data.TodoDto
import com.example.loginproject.ui.theme.LoginProjectTheme
import com.example.loginproject.ui.theme.authGradientBrush
import com.example.loginproject.viewmodel.TodoUiState
import com.example.loginproject.viewmodel.TodoViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun TodoScreen(
    onBackClick: () -> Unit,
    viewModel: TodoViewModel = koinViewModel()
) {
    TodoContent(
        uiState = viewModel.uiState,
        onRetryClick = viewModel::loadTodo,
        onBackClick = onBackClick
    )
}

@Composable
private fun TodoContent(
    uiState: TodoUiState = TodoUiState.Loading,
    onRetryClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = authGradientBrush())
            .padding(horizontal = 28.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HeadingTextComponent(value = stringResource(R.string.heading_todo))

        Spacer(modifier = Modifier.height(32.dp))

        when (uiState) {
            is TodoUiState.Loading -> CircularProgressIndicator(color = Color.White)

            is TodoUiState.Success -> TodoDetails(todo = uiState.todo)

            is TodoUiState.Error -> {
                ErrorTextComponent(value = uiState.message)
                Spacer(modifier = Modifier.height(20.dp))
                ButtonComponent(
                    value = stringResource(R.string.action_retry_button),
                    onClick = onRetryClick
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = stringResource(R.string.action_back_button),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable(onClick = onBackClick)
        )
    }
}

@Composable
private fun TodoDetails(todo: TodoDto) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = todo.title,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(
                if (todo.completed) R.string.label_completed else R.string.label_not_completed
            ),
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TodoContentLoadingPreview() {
    LoginProjectTheme {
        TodoContent(uiState = TodoUiState.Loading)
    }
}

@Preview(showBackground = true)
@Composable
private fun TodoContentSuccessPreview() {
    LoginProjectTheme {
        TodoContent(
            uiState = TodoUiState.Success(
                TodoDto(userId = 1, id = 1, title = "delectus aut autem", completed = false)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TodoContentErrorPreview() {
    LoginProjectTheme {
        TodoContent(uiState = TodoUiState.Error(message = "Something went wrong. Please try again."))
    }
}
