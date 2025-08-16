package com.ifound.ui.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ifound.ui.models.CommonButtonType
import com.ifound.ui.theme.Alpha
import com.ifound.ui.theme.IfoundTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    type: CommonButtonType = CommonButtonType.Primary,
    enabled: Boolean = true,
    isLoading: Boolean = false,
) {
    val colors: Pair<Color, Color> = when(type) {
        CommonButtonType.Primary -> Pair(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.surface
        )
        CommonButtonType.Secondary -> Pair(
            MaterialTheme.colorScheme.tertiary,
            MaterialTheme.colorScheme.onSurface
        )
    }

    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = !isLoading && enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.first
        ),
        contentPadding = PaddingValues(
            vertical = 15.dp,
            horizontal = 24.dp
        ),
        shape = RoundedCornerShape(
            12.dp
        )
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if(isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = colors.second,
                    trackColor = colors.second.copy(alpha = Alpha.DISABLED),
                )
                Spacer(Modifier.width(10.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.titleMediumEmphasized,
                color = colors.second
            )
        }

    }
}


@Preview
@Composable
private fun CommonButtonPreview() {
    IfoundTheme {
        CommonButton(
            text = "Hello World",
            onClick = {},
            isLoading = true
        )
    }
}