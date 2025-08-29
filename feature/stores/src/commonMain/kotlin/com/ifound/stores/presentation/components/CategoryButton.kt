package com.ifound.stores.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ifound.ui.UiRes
import com.ifound.ui.theme.Alpha
import com.ifound.ui.theme.IfoundTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CategoryButton(
    modifier: Modifier = Modifier,
    selected: Boolean = false
) {
    OutlinedButton(
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if(selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            contentColor = if(selected) MaterialTheme.colorScheme.onSurface  else MaterialTheme.colorScheme.secondary
        ),
        shape = MaterialTheme.shapes.extraLarge,
        contentPadding = PaddingValues(
            vertical = 14.dp,
            horizontal = 18.dp
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if(selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.DISABLED)
        ),

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(UiRes.Drawable.ic_map),
                contentDescription = "Category icon",
                modifier = Modifier.size(23.dp),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Category",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CategoryButtonPreview() {
    IfoundTheme {
        CategoryButton(
            selected = true
        )
    }
}