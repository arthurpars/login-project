package com.example.loginproject.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginproject.R
import com.example.loginproject.ui.theme.LoginProjectTheme

@Composable
private fun underlineTextFieldColors() = TextFieldDefaults.colors(
    focusedContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    disabledContainerColor = Color.Transparent,
    focusedIndicatorColor = colorResource(id = R.color.accent_red),
    unfocusedIndicatorColor = colorResource(id = R.color.underline_gray),
    cursorColor = colorResource(id = R.color.accent_red)
)

private val flushContentPadding = PaddingValues(horizontal = 0.dp, vertical = 8.dp)

@Composable
private fun UnderlineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation,
    placeholder: (@Composable () -> Unit)?
) {
    val interactionSource = remember { MutableInteractionSource() }
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(color = colorResource(id = R.color.text_dark)),
        cursorBrush = SolidColor(colorResource(id = R.color.accent_red)),
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp)
    ) { innerTextField ->
        TextFieldDefaults.DecorationBox(
            value = value,
            innerTextField = innerTextField,
            enabled = true,
            singleLine = true,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource,
            placeholder = placeholder,
            colors = underlineTextFieldColors(),
            contentPadding = flushContentPadding
        )
    }
}

@Composable
internal fun StandardTextFieldComponent(
    labelValue: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholderValue: String = ""
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = labelValue,
            color = colorResource(id = R.color.accent_red),
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        UnderlineTextField(
            value = value,
            onValueChange = onValueChange,
            visualTransformation = VisualTransformation.None,
            placeholder = {
                Text(
                    text = placeholderValue,
                    color = colorResource(id = R.color.placeholder_gray)
                )
            }
        )
    }
}

@Composable
internal fun PasswordTextFieldComponent(
    labelValue: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = labelValue,
            color = colorResource(id = R.color.accent_red),
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        UnderlineTextField(
            value = value,
            onValueChange = onValueChange,
            visualTransformation = PasswordVisualTransformation(),
            placeholder = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TextFieldsPreview() {
    LoginProjectTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            StandardTextFieldComponent(
                labelValue = "Email",
                value = email,
                placeholderValue = "Enter your email",
                onValueChange = { email = it }
            )
            PasswordTextFieldComponent(
                labelValue = "Password",
                value = password,
                onValueChange = { password = it }
            )
        }
    }
}