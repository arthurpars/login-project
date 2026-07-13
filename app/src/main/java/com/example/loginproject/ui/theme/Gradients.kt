package com.example.loginproject.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import com.example.loginproject.R

@Composable
fun authGradientBrush(): Brush = Brush.horizontalGradient(
    colors = listOf(colorResource(R.color.gradient_start), colorResource(R.color.gradient_end))
)