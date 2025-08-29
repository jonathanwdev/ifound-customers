package com.ifound.ui.components.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ifound.ui.theme.IfoundTheme
import ifound.core.ui.generated.resources.Res
import ifound.core.ui.generated.resources.ic_like
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun CommonTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    leadingIcon: DrawableResource? = null,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Row(
        modifier = modifier.padding(vertical = 5.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable(enabled) {
                onClick()
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row {
            leadingIcon?.let {
                Icon(
                    painter = painterResource(it),
                    tint = color,
                    contentDescription = "leading icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(8.dp))
            }
            Text(
                text = text,
                color = color,
                style = MaterialTheme.typography.bodyLargeEmphasized.copy(fontWeight = FontWeight.SemiBold)
            )
        }
    }
}

@Preview
@Composable
private fun CommonTextButtonPreview() {
    IfoundTheme {
        CommonTextButton(
            onClick = {},
            text = "Already have an account? Log in here.",
        )
    }
}

@Preview
@Composable
private fun CommonTextButtonWithLeadingIconPreview() {
    IfoundTheme {
        CommonTextButton(
            onClick = {},
            text = "Already have an account? Log in here.",
            leadingIcon = Res.drawable.ic_like
        )
    }
}