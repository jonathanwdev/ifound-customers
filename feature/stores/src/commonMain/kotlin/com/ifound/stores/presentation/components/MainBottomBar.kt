package com.ifound.stores.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ifound.ui.UiRes
import com.ifound.ui.theme.Alpha
import org.jetbrains.compose.resources.painterResource


@Composable
fun MainBottomBar(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
    ) {
        NavigationBarItem(
            selected = true,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.HALF),
                unselectedTextColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.HALF),
                indicatorColor = Color.Transparent
            ),
            icon = {
                Icon(
                    painter = painterResource(UiRes.Drawable.ic_home),
                    contentDescription = "Home"
                )
            },
            label = {
                Text(text = "Home")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.HALF),
                unselectedTextColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.HALF),
                indicatorColor = Color.Transparent
            ),
            icon = {
                Icon(
                    painter = painterResource(UiRes.Drawable.ic_calendar),
                    contentDescription = "Bookings"
                )
            },
            label = {
                Text(text = "Bookings")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.HALF),
                unselectedTextColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.HALF),
                indicatorColor = Color.Transparent
            ),
            icon = {
                Icon(
                    painter = painterResource(UiRes.Drawable.ic_map),
                    contentDescription = "View Map"
                )
            },
            label = {
                Text(text = "View Map")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.HALF),
                unselectedTextColor = MaterialTheme.colorScheme.secondary.copy(alpha = Alpha.HALF),
                indicatorColor = Color.Transparent
            ),
            icon = {
                Icon(
                    painter = painterResource(UiRes.Drawable.ic_person_rounded),
                    contentDescription = "Profile"
                )
            },
            label = {
                Text(text = "Profile")
            }
        )
    }
}
