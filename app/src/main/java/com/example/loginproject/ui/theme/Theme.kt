package com.example.loginproject.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import com.example.loginproject.R

@Composable
fun LoginProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true, content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColorScheme(
            primary = colorResource(R.color.purple_80),
            secondary = colorResource(R.color.purple_grey_80),
            tertiary = colorResource(R.color.pink_80)
        )

        else -> lightColorScheme(
            primary = colorResource(R.color.purple_40),
            secondary = colorResource(R.color.purple_grey_40),
            tertiary = colorResource(R.color.pink_40)
        )
    }

    MaterialTheme(
        colorScheme = colorScheme, typography = Typography, content = content
    )
}