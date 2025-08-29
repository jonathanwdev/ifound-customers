package com.ifound.stores.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifound.ui.UiRes
import com.ifound.ui.theme.Alpha
import ifound.feature.stores.generated.resources.Res
import ifound.feature.stores.generated.resources.sign_out
import ifound.feature.stores.generated.resources.view_all_on_map
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    title: String,
    onLeftIconClick: () -> Unit,
) {
    var dropDownExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(UiRes.Drawable.ic_location_filled),
                    contentDescription = "Change location",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(17.dp)
                )
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Icon(
                    painter = painterResource(UiRes.Drawable.ic_arrow_down),
                    contentDescription = "Change location",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(18.dp)
                )
            }
        },
        navigationIcon = {

        },
        actions = {
            IconButton(
                onClick = {
                    dropDownExpanded = true
                }
            ) {
                Icon(
                    painter = painterResource(UiRes.Drawable.ic_more_menu),
                    contentDescription = "Open Menu"
                )
            }
            DropdownMenu(
                expanded = dropDownExpanded,
                onDismissRequest = {
                    dropDownExpanded = false
                },
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                DropdownMenuItem(
                    colors = MenuItemColors(
                        leadingIconColor = MaterialTheme.colorScheme.secondary,
                        trailingIconColor = MaterialTheme.colorScheme.secondary,
                        textColor = MaterialTheme.colorScheme.secondary,
                        disabledTextColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.DISABLED),
                        disabledLeadingIconColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.DISABLED),
                        disabledTrailingIconColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.DISABLED)

                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(UiRes.Drawable.ic_map),
                            contentDescription = stringResource(Res.string.view_all_on_map)
                        )
                    },
                    text = {
                        Text(
                            text = stringResource(Res.string.view_all_on_map),
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
                        )
                    },
                    onClick = {
                        dropDownExpanded = false
                    }

                )
                DropdownMenuItem(
                    colors = MenuItemColors(
                        leadingIconColor = MaterialTheme.colorScheme.secondary,
                        trailingIconColor = MaterialTheme.colorScheme.secondary,
                        textColor = MaterialTheme.colorScheme.secondary,
                        disabledTextColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.DISABLED),
                        disabledLeadingIconColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.DISABLED),
                        disabledTrailingIconColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.DISABLED)

                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(UiRes.Drawable.ic_door_open),
                            contentDescription = stringResource(Res.string.sign_out)
                        )
                    },
                    text = {
                        Text(
                            text = stringResource(Res.string.sign_out),
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
                        )
                    },
                    onClick = {
                        dropDownExpanded = false
                    }
                )
            }
        }

    )
}