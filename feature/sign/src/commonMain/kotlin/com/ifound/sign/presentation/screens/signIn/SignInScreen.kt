package com.ifound.sign.presentation.screens.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ifound.ui.UiRes
import com.ifound.ui.components.common.CommonButton
import com.ifound.ui.components.common.CommonTextButton
import com.ifound.ui.components.common.CommonTextField
import com.ifound.ui.helpers.stringHelpers.capitalizeAllFirstLetter
import com.ifound.ui.helpers.stringHelpers.capitalizeFirstLetter
import com.ifound.ui.models.ButtonStyle
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import ifound.feature.sign.generated.resources.Res
import ifound.feature.sign.generated.resources.email
import ifound.feature.sign.generated.resources.forgot_password_sign_in_message
import ifound.feature.sign.generated.resources.password
import ifound.feature.sign.generated.resources.sign_in
import ifound.feature.sign.generated.resources.sign_up
import ifound.feature.sign.generated.resources.welcome_back_sign_in_message
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun SignInScreen(
    onNavigateToSignUp: () -> Unit,
    onNavigateToRecoverPassword: () -> Unit,
    onNavigateToHome: () -> Unit,
) {
    val viewModel = koinViewModel<SignInViewModel>()
    val uiState = viewModel.uiState
    val uiEvent = viewModel.event

    LaunchedEffect(Unit) {
        uiEvent.collect { event ->
            when(event) {
                is SignInViewModel.SignInScreenEvents.SignSuccess -> {
                    onNavigateToHome()
                }
                is SignInViewModel.SignInScreenEvents.SignError -> {
                    onNavigateToHome()
                }
            }
        }
    }

    SignInView(
        uiState = uiState,
        onFormEven = viewModel::onFormEvent,
        onNavigateToSignUp = onNavigateToSignUp,
        onNavigateToRecoverPassword = onNavigateToRecoverPassword
    )
}


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun SignInView(
    uiState: SignInUiState,
    onFormEven: (SignInFormEvent) -> Unit,
    onNavigateToSignUp: () -> Unit,
    onNavigateToRecoverPassword: () -> Unit
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding(),
                )
                .fillMaxSize()
                .padding(horizontal = Spacings.MARGIN_HORIZONTAL),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .imePadding(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(UiRes.Drawable.logo_outline_black_yellow),
                    modifier = Modifier.height(25.dp),
                    contentDescription = "Company Logo"
                )
                Spacer(Modifier.height(30.dp))
                Text(
                    text = stringResource(Res.string.welcome_back_sign_in_message),
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Spacer(Modifier.height(35.dp))
                CommonTextField(
                    value = uiState.email,
                    isErrorMessage = uiState.emailError,
                    onValueChange = {
                        onFormEven(SignInFormEvent.OnEmailChanged(it))
                    },
                    placeholder = stringResource(Res.string.email).capitalizeFirstLetter(),
                    leadingIcon = UiRes.Drawable.ic_at,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(15.dp))
                CommonTextField(
                    value = uiState.password,
                    isErrorMessage = uiState.passwordError,
                    onValueChange = {
                        onFormEven(SignInFormEvent.OnPasswordChanged(it))
                    },
                    placeholder = stringResource(Res.string.password).capitalizeFirstLetter(),
                    leadingIcon = UiRes.Drawable.ic_lock,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(15.dp))
                CommonButton(
                    text = stringResource(Res.string.sign_in).capitalizeAllFirstLetter(),
                    isLoading = uiState.isLoading,
                    onClick = {
                        onFormEven(SignInFormEvent.OnSubmit)
                    },
                    modifier = Modifier,
                    buttonStyle = ButtonStyle.Primary,
                )

            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CommonButton(
                    text = stringResource(Res.string.sign_up).capitalizeAllFirstLetter(),
                    enabled = !uiState.isLoading,
                    onClick = onNavigateToSignUp,
                    modifier = Modifier,
                    buttonStyle = ButtonStyle.Secondary
                )
                Spacer(Modifier.height(10.dp))
                CommonTextButton(
                    enabled = !uiState.isLoading,
                    onClick = onNavigateToRecoverPassword,
                    text = stringResource(Res.string.forgot_password_sign_in_message),
                    leadingIcon = UiRes.Drawable.ic_lock_reset
                )
            }
        }
    }
}


@Preview()
@Composable
private fun SignInScreenPreview() {
    IfoundTheme {
        SignInView(
            uiState = SignInUiState(),
            onFormEven = {},
            onNavigateToSignUp = {},
            onNavigateToRecoverPassword = {}
        )
    }

}