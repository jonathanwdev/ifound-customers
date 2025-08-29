package com.ifound.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.PermissionsController
import dev.icerock.moko.permissions.RequestCanceledException
import dev.icerock.moko.permissions.compose.BindEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

data class MokoPermissionState(
    val state: PermissionState,
    val requestPermission: () -> Unit,
    val refresh: () -> Unit
)

@Composable
fun rememberMokoPermissionState(
    controller: PermissionsController,
    permission: Permission,
    scope: CoroutineScope = rememberCoroutineScope(),
): MokoPermissionState {
    var state by remember { mutableStateOf(PermissionState.NotDetermined) }

    LaunchedEffect(permission) {
        state = controller.getPermissionState(permission)
    }

    return MokoPermissionState(
        state = state,
        requestPermission = {
            scope.launch {
                try {
                    controller.providePermission(permission)
                    state = PermissionState.Granted
                } catch(e: DeniedAlwaysException) {
                    state = PermissionState.DeniedAlways
                } catch(e: DeniedException) {
                    state = PermissionState.Denied
                } catch(e: RequestCanceledException) {
                    state = PermissionState.NotDetermined
                }

            }
        },
        refresh = {
            scope.launch {
                state = controller.getPermissionState(permission)
            }
        }
    )
}