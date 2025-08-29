package com.ifound.ui.components.common

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ifound.ui.models.ButtonSizes
import com.ifound.ui.models.ButtonStyle
import com.ifound.ui.theme.Alpha
import com.ifound.ui.theme.IfoundTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    leadingIcon: DrawableResource? = null,
    trailingIcon: DrawableResource? = null,
    sizes: ButtonSizes = ButtonSizes.FULL,
    buttonStyle: ButtonStyle = ButtonStyle.Primary,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    isLoading: Boolean = false,
    elevation: ButtonElevation? = null,
) {

    Button(
        modifier = modifier.then(
            if (sizes == ButtonSizes.FULL) {
                Modifier.fillMaxWidth()
            } else {
                Modifier
            }
        ),
        elevation = elevation,
        onClick = onClick,
        enabled = !isLoading && enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonStyle.first.copy(alpha = if (enabled) Alpha.FULL else Alpha.DISABLED)
        ),
        contentPadding = sizes.padding,
        shape = shape,
    ) {
        Row(
            modifier = Modifier.then(
                if (sizes == ButtonSizes.FULL) {
                    Modifier
                        .weight(1f)
                } else {
                    Modifier
                }
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AnimatedContent(
                targetState = isLoading
            ) { loading ->
                if (loading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(if (sizes == ButtonSizes.FULL) 24.dp else 16.dp),
                        color = buttonStyle.second,
                        trackColor = buttonStyle.second.copy(alpha = Alpha.DISABLED),
                    )

                }
                if (leadingIcon != null && !loading) {
                    Icon(
                        painter = painterResource(leadingIcon),
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(if (sizes == ButtonSizes.FULL) 24.dp else 16.dp),
                        contentDescription = null,
                        tint = buttonStyle.second
                    )
                }
            }
            Text(
                text = text,
                style = MaterialTheme.typography.titleMediumEmphasized.copy(fontWeight = FontWeight.Bold),
                color = buttonStyle.second
            )
            if (trailingIcon != null) {
                Icon(
                    painter = painterResource(trailingIcon),
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(if (sizes == ButtonSizes.FULL) 24.dp else 16.dp),
                    contentDescription = null,
                    tint = buttonStyle.second
                )
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun CommonButtonFullPreview() {
    IfoundTheme {
        CommonButton(
            text = "Hello World",
            onClick = {},
            enabled = false,
            isLoading = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CommonButtonSmallPreview() {
    IfoundTheme {
        CommonButton(
            text = "Hello",
            onClick = {},
            enabled = false,
            buttonStyle = ButtonStyle.Primary,
            sizes = ButtonSizes.SMALL,
            isLoading = true
        )
    }
}