package com.ifound.ui.helpers.extensions

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

fun KeyboardType.getKeyboardVisualTransformation(isVisible: Boolean): VisualTransformation {
    return if (this == KeyboardType.Password) {
        if (isVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    } else {
        VisualTransformation.None
    }
}