package com.ifound.sign.presentation.screens.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ifound.common.utils.currentPlatform
import com.ifound.ui.UiRes
import com.ifound.ui.components.common.CommonButton
import com.ifound.ui.components.common.CommonTextButton
import com.ifound.ui.components.common.CommonTextField
import com.ifound.ui.helpers.stringHelpers.capitalizeAllFirstLetter
import com.ifound.ui.helpers.stringHelpers.capitalizeFirstLetter
import com.ifound.ui.state.rememberMokoPermissionState
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import dev.icerock.moko.geo.compose.BindLocationTrackerEffect
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.compose.BindEffect
import dev.icerock.moko.permissions.location.LOCATION
import ifound.feature.sign.generated.resources.Res
import ifound.feature.sign.generated.resources.address
import ifound.feature.sign.generated.resources.already_have_account_sign_up_message
import ifound.feature.sign.generated.resources.click_to_get_location_sign_up_message
import ifound.feature.sign.generated.resources.email
import ifound.feature.sign.generated.resources.enable_location_sign_up_message
import ifound.feature.sign.generated.resources.name
import ifound.feature.sign.generated.resources.password
import ifound.feature.sign.generated.resources.password_confirmation
import ifound.feature.sign.generated.resources.sign_up
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignUpScreen(
    onGoBack: () -> Unit,

) {
    val viewModel = koinViewModel<SignUpViewModel>()
    val uiState = viewModel.uiState

    val permissionState = rememberMokoPermissionState(
        viewModel.permissionsController,
        Permission.LOCATION
    )


    BindEffect(viewModel.permissionsController)
    BindLocationTrackerEffect(locationTracker = viewModel.locationTracker)

    SignUpView(
        onGoBack = onGoBack,
        onFormEvent = viewModel::formEvent,
        onSearchAddress = viewModel::getLocation,
        permissionState = permissionState.state,
        onRequestPermission = {
            permissionState.requestPermission()
        },
        onOpenSettings = {
            viewModel.permissionsController.openAppSettings()
        },
        uiState = uiState
    )


}

@Composable
fun SignUpView(
    onGoBack: () -> Unit,
    onFormEvent: (SignUpFormEvent) -> Unit,
    onRequestPermission: () -> Unit,
    onOpenSettings: () -> Unit,
    onSearchAddress: () -> Unit,
    permissionState: PermissionState,
    uiState: SignUpUiState
) {

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 25.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(UiRes.Drawable.logo_outline_black_yellow),
                    contentDescription = "company logo",
                    modifier = Modifier.height(23.dp)
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding(),
                )
                .fillMaxSize()
                .padding(horizontal = Spacings.MARGIN_HORIZONTAL)
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(17.dp))
            Text(
                text = "Join Ifound today!",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface,
            )
            Spacer(Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                CommonTextField(
                    onValueChange = {
                        onFormEvent(SignUpFormEvent.OnNameChanged(it))
                    },
                    value = uiState.name,
                    placeholder = stringResource(Res.string.name).capitalizeFirstLetter(),
                    leadingIcon = UiRes.Drawable.ic_person_rounded,
                )
                CommonTextField(
                    onValueChange = {
                        onFormEvent(SignUpFormEvent.OnEmailChanged(it))
                    },
                    value = uiState.email,
                    placeholder = stringResource(Res.string.email).capitalizeFirstLetter(),
                    leadingIcon = UiRes.Drawable.ic_at,
                )
                CommonTextField(
                    onValueChange = {
                        onFormEvent(SignUpFormEvent.OnAddressChanged(it))
                    },
                    value = uiState.address,
                    placeholder = stringResource(Res.string.address).capitalizeFirstLetter(),
                    leadingIcon = UiRes.Drawable.ic_location_pin,
                )
                if (permissionState == PermissionState.Granted) {
                    CommonTextButton(
                        onClick = {
                            onSearchAddress()
                        },
                        text = stringResource(Res.string.click_to_get_location_sign_up_message),
                        leadingIcon = UiRes.Drawable.ic_location_pin,
                        modifier = Modifier.padding(start = 12.dp)
                    )
                } else {
                    CommonTextButton(
                        onClick = {
                            if (
                                permissionState == PermissionState.DeniedAlways
                                || permissionState == PermissionState.Denied
                            ) {
                                onOpenSettings()
                            } else {
                                onRequestPermission()
                            }
                        },
                        text = stringResource(Res.string.enable_location_sign_up_message),
                        leadingIcon = UiRes.Drawable.ic_location_edit,
                        modifier = Modifier.padding(start = 12.dp)
                    )
                }
                CommonTextField(
                    onValueChange = {
                        onFormEvent(SignUpFormEvent.OnPasswordChanged(it))
                    },
                    value = uiState.password,
                    placeholder = stringResource(Res.string.password).capitalizeFirstLetter(),
                    leadingIcon = UiRes.Drawable.ic_lock,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                )
                CommonTextField(
                    onValueChange = {
                        onFormEvent(SignUpFormEvent.OnPasswordConfirmationChanged(it))
                    },
                    value = uiState.passwordConfirmation,
                    placeholder = stringResource(Res.string.password_confirmation).capitalizeAllFirstLetter(),
                    leadingIcon = UiRes.Drawable.ic_lock,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                )
                Spacer(Modifier.height(10.dp))
            }
            CommonButton(
                text = stringResource(Res.string.sign_up).capitalizeAllFirstLetter(),
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                isLoading = uiState.isLoading,
                onClick = {
                    onFormEvent(SignUpFormEvent.OnSubmit)
                }
            )
            Spacer(Modifier.height(7.dp))
            CommonTextButton(
                onClick = onGoBack,
                text = stringResource(Res.string.already_have_account_sign_up_message),
                leadingIcon = UiRes.Drawable.ic_person_rounded
            )

        }

    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    IfoundTheme {
        SignUpView(
            onGoBack = {},
            onFormEvent = {},
            onRequestPermission = {},
            uiState = SignUpUiState(),
            onOpenSettings = {},
            onSearchAddress = {},
            permissionState = PermissionState.Granted
        )

    }
}

