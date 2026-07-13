package com.example.loginproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginproject.R
import com.example.loginproject.components.OutlinedPillButton
import com.example.loginproject.components.SocialIconBadge
import com.example.loginproject.components.SolidWhitePillButton
import com.example.loginproject.ui.theme.LoginProjectTheme
import com.example.loginproject.ui.theme.authGradientBrush

@Composable
internal fun WelcomeScreen(onSignInClick: () -> Unit, onSignUpClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = authGradientBrush())
            .padding(horizontal = 32.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(id = R.drawable.ic_dumbbell),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(48.dp)
        )

        Text(
            text = stringResource(R.string.brand_name),
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 2.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = stringResource(R.string.heading_welcome_back),
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedPillButton(
            value = stringResource(R.string.action_sign_in_button),
            onClick = onSignInClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        SolidWhitePillButton(
            value = stringResource(R.string.action_sign_up_button),
            onClick = onSignUpClick
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = stringResource(R.string.prompt_social_login),
            color = Color.White,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            SocialIconBadge(iconRes = R.drawable.ic_instagram)
            SocialIconBadge(iconRes = R.drawable.ic_twitter)
            SocialIconBadge(iconRes = R.drawable.ic_facebook)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    LoginProjectTheme {
        WelcomeScreen(onSignInClick = {}, onSignUpClick = {})
    }
}