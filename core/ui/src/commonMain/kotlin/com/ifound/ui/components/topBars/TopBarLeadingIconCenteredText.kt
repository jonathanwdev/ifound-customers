package com.ifound.ui.components.topBars

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ifound.core.ui.generated.resources.Res
import ifound.core.ui.generated.resources.ic_arrow_back
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarLeadingIconCenteredText(
    title: String? = null,
    icon: DrawableResource? = null,
    actionIcon: DrawableResource? = null,
    onLeadingIconClick: () -> Unit,
    onActionIconClick: (() -> Unit)? = null,
) {
    CenterAlignedTopAppBar(
        title = {
            title?.let {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = onLeadingIconClick
            ) {
                if (icon != null) {
                    Icon(
                        painter = painterResource(icon),
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colorScheme.onSurface,
                        contentDescription = "left icon"
                    )
                } else {
                    Icon(
                        painter = painterResource(Res.drawable.ic_arrow_back),
                        contentDescription = "go back"
                    )
                }

            }
        },
        actions = {
            actionIcon?.let {
                IconButton(
                    onClick = { onActionIconClick?.invoke() }
                ) {
                    Icon(
                        painter = painterResource(actionIcon),
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colorScheme.onSurface,
                        contentDescription = "action icon"
                    )
                }
            }
        }

    )
}