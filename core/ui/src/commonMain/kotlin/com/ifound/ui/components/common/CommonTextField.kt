package com.ifound.ui.components.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifound.ui.helpers.extensions.getKeyboardVisualTransformation
import com.ifound.ui.theme.IfoundTheme
import ifound.core.ui.generated.resources.Res
import ifound.core.ui.generated.resources.ic_eye
import ifound.core.ui.generated.resources.ic_eye_blind
import ifound.core.ui.generated.resources.ic_person_rounded
import ifound.core.ui.generated.resources.ic_search
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun CommonTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String = "",
    isErrorMessage: String? = null,
    placeholder: String? = null,
    leadingIcon: DrawableResource? = null,
    trailingIcon: DrawableResource? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next
    )
) {
    var showPassword by remember { mutableStateOf(false) }

    Column {
        TextField(
            modifier = modifier.fillMaxWidth(),
            onValueChange = onValueChange,
            value = value,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.tertiary,
                focusedContainerColor = MaterialTheme.colorScheme.tertiary,
                errorContainerColor = MaterialTheme.colorScheme.tertiary,
                focusedPlaceholderColor = MaterialTheme.colorScheme.onTertiary,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onTertiary,
                errorTextColor = MaterialTheme.colorScheme.error,
                errorPlaceholderColor = MaterialTheme.colorScheme.error,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                errorTrailingIconColor = MaterialTheme.colorScheme.error,
                errorLeadingIconColor = MaterialTheme.colorScheme.error,
                unfocusedTrailingIconColor = MaterialTheme.colorScheme.onTertiary,
                focusedTrailingIconColor = MaterialTheme.colorScheme.onTertiary,
                unfocusedLeadingIconColor = MaterialTheme.colorScheme.onTertiary,
                focusedLeadingIconColor = MaterialTheme.colorScheme.onTertiary,
                selectionColors = TextSelectionColors(
                    handleColor = MaterialTheme.colorScheme.onSurface,
                    backgroundColor = Color.Unspecified
                )
            ),
            isError = isErrorMessage != null,
            visualTransformation = keyboardOptions.keyboardType.getKeyboardVisualTransformation(
                showPassword
            ),
            singleLine = true,
            keyboardOptions = keyboardOptions,
            shape = MaterialTheme.shapes.extraLarge,
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            leadingIcon = {
                leadingIcon?.let { icon ->
                    Icon(
                        painter = painterResource(icon),
                        modifier = Modifier.size(23.dp),
                        contentDescription = "leading icon"
                    )
                }

            },
            trailingIcon = {
                if (keyboardOptions.keyboardType == KeyboardType.Password) {
                    Icon(
                        painter = painterResource(if (showPassword) Res.drawable.ic_eye_blind else Res.drawable.ic_eye),
                        contentDescription = "show password",
                        modifier = Modifier.size(23.dp).clickable {
                            showPassword = !showPassword
                        }
                    )
                } else {
                    trailingIcon?.let { icon ->
                        Icon(
                            painter = painterResource(icon),
                            contentDescription = "trailing icon",
                            modifier = Modifier.size(24.dp).clickable(onTrailingIconClick != null) {
                                onTrailingIconClick?.invoke()
                            }
                        )
                    }
                }

            },
            placeholder = {
                placeholder?.let { place ->
                    Text(
                        text = place,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        )
        isErrorMessage?.let { error ->
            Spacer(Modifier.height(1.dp))
            Text(
                text = isErrorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 11.sp
                ),
                modifier = Modifier.padding(start = 14.dp)
            )
        }
    }
}


@Preview
@Composable
private fun CommonTextFieldPreview() {
    IfoundTheme {
        CommonTextField(
            onValueChange = {},
            value = "",
            placeholder = "Placeholder"

        )
    }
}


@Preview
@Composable
private fun CommonTextFieldWithIconPreview() {
    IfoundTheme {
        CommonTextField(
            onValueChange = {},
            value = "",
            leadingIcon = Res.drawable.ic_search,
            placeholder = "Search"
        )
    }
}

@Preview
@Composable
private fun CommonTextFieldWithPasswordPreview() {
    IfoundTheme {
        CommonTextField(
            onValueChange = {},
            value = "",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = Res.drawable.ic_person_rounded,
            placeholder = "Password"
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun CommonTextFieldWithPasswordError() {
    IfoundTheme {
        CommonTextField(
            onValueChange = {},
            value = "error",
            isErrorMessage = "Invalid credentials",
            leadingIcon = Res.drawable.ic_person_rounded,
            placeholder = "Password"
        )
    }
}