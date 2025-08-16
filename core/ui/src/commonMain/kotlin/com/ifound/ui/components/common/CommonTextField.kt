package com.ifound.ui.components.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
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


@Composable
fun CommonTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String = "",
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

    TextField(
        modifier = modifier.fillMaxWidth(),
        onValueChange = onValueChange,
        value = value,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.tertiary,
            focusedContainerColor = MaterialTheme.colorScheme.tertiary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.onTertiary,
            focusedTrailingIconColor = MaterialTheme.colorScheme.onTertiary,
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.onTertiary,
            focusedLeadingIconColor = MaterialTheme.colorScheme.onTertiary,
            selectionColors = TextSelectionColors(
                handleColor = MaterialTheme.colorScheme.onSurface,
                backgroundColor = Color.Unspecified
            )
        ),
        visualTransformation = keyboardOptions.keyboardType.getKeyboardVisualTransformation(showPassword),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        shape = RoundedCornerShape(
            12.dp
        ),
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
                    color = MaterialTheme.colorScheme.onTertiary,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                )
            }
        }
    )
}


@Preview
@Composable
private fun CommonTextFieldPreview() {
    IfoundTheme {
        CommonTextField(
            onValueChange = {},
            value = "Hello text field",
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