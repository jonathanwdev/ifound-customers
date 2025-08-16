package com.ifound.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifound.ui.theme.IfoundTheme
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CommonOtpTextField(
    modifier: Modifier = Modifier,
    size: Int = 6,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text
    )
) {
    val state = rememberTextFieldState(initialText = value)

    LaunchedEffect(Unit) { // Executa uma vez para configurar o listener
        snapshotFlow { state.text.toString() }
            .distinctUntilChanged()
            .filter { newText ->
                val isValid = newText.all { it.isDigit() } && newText.length <= size
                if (!isValid && newText.isNotEmpty() && newText.length > state.text.toString().length) {
                    state.edit {
                        val currentText: CharSequence = this.originalText
                        replace(0, currentText.length, value)
                    }
                }
                isValid || newText.isEmpty()
            }
            .collect { validText ->
                if (value != validText) {
                    onValueChange(validText)
                }
            }
    }
    BasicTextField(
        state = state,
        modifier = modifier,
        inputTransformation = InputTransformation.maxLength(size),
        keyboardOptions = keyboardOptions,
        decorator = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val currentText = state.text.toString()
                repeat(size) { idx ->
                    val chatToShadow = currentText.getOrNull(idx) ?: ""
                    Box(
                        modifier = Modifier
                            .size(
                                height = 48.dp,
                                width = 48.dp
                            )
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.tertiary)
                    ) {
                        Text(
                            text = chatToShadow.toString() ?: "",
                            modifier = Modifier.align(Alignment.Center),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }
        }
    )
}


@Preview
@Composable
private fun CommonOtpTextFieldPreview() {
    IfoundTheme {
        CommonOtpTextField(
            value = "123456",
            onValueChange = {}
        )
    }
}