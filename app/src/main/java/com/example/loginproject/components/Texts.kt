package com.example.loginproject.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginproject.R
import com.example.loginproject.ui.theme.LoginProjectTheme
import com.example.loginproject.ui.theme.authGradientBrush

@Composable
internal fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        color = Color.White,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 36.sp
    )
}

@Composable
internal fun ClickableTextComponent(value: String, onClick: () -> Unit) {
    Text(
        text = value,
        color = colorResource(id = R.color.text_dark),
        fontWeight = FontWeight.Bold,
        modifier = Modifier.clickable(onClick = onClick)
    )
}

@Composable
internal fun PromptTextComponent(value: String) {
    Text(text = value, color = colorResource(id = R.color.prompt_gray), fontSize = 13.sp)
}

@Composable
internal fun ErrorTextComponent(value: String) {
    Text(
        text = value,
        color = colorResource(id = R.color.error_red),
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
private fun TextsPreview() {
    LoginProjectTheme {
        Column(
            modifier = Modifier
                .background(brush = authGradientBrush())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            HeadingTextComponent(value = "Hello,")
            ClickableTextComponent(value = "Sign Up", onClick = {})
            PromptTextComponent(value = "Don't have an account?")
            ErrorTextComponent(value = "Something went wrong")
        }
    }
}