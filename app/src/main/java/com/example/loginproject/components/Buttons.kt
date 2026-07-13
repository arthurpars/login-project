package com.example.loginproject.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginproject.R
import com.example.loginproject.ui.theme.LoginProjectTheme
import com.example.loginproject.ui.theme.authGradientBrush

private val pillButtonModifier = Modifier
    .fillMaxWidth()
    .height(52.dp)
    .clip(RoundedCornerShape(50))

@Composable
private fun PillButtonText(value: String, color: Color) {
    Text(
        text = value,
        color = color,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 1.sp
    )
}

@Composable
internal fun ButtonComponent(value: String, onClick: () -> Unit) {
    Box(
        modifier = pillButtonModifier
            .background(brush = authGradientBrush())
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        PillButtonText(value = value, color = Color.White)
    }
}

@Composable
internal fun OutlinedPillButton(value: String, onClick: () -> Unit) {
    Box(
        modifier = pillButtonModifier
            .border(width = 1.5.dp, color = Color.White, shape = RoundedCornerShape(50))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        PillButtonText(value = value, color = Color.White)
    }
}

@Composable
internal fun SolidWhitePillButton(value: String, onClick: () -> Unit) {
    Box(
        modifier = pillButtonModifier
            .background(Color.White)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        PillButtonText(value = value, color = colorResource(id = R.color.accent_red))
    }
}

@Preview(showBackground = true)
@Composable
private fun PillButtonsPreview() {
    LoginProjectTheme {
        Column(
            modifier = Modifier
                .background(brush = authGradientBrush())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ButtonComponent(value = "SIGN IN", onClick = {})
            OutlinedPillButton(value = "SIGN IN", onClick = {})
            SolidWhitePillButton(value = "SIGN UP", onClick = {})
            SocialIconBadge(iconRes = R.drawable.ic_instagram)
        }
    }
}