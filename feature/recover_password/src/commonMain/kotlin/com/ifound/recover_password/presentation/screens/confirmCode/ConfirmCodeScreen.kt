package com.ifound.recover_password.presentation.screens.confirmCode

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifound.ui.UiRes
import com.ifound.ui.components.common.CommonButton
import com.ifound.ui.components.common.CommonOtpTextField
import com.ifound.ui.components.common.CommonTextButton
import com.ifound.ui.components.topBars.TopBarLeadingIconCenteredText
import com.ifound.ui.helpers.stringHelpers.capitalizeFirstLetter
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import ifound.feature.recover_password.generated.resources.Res
import ifound.feature.recover_password.generated.resources.did_not_receive_email_resend_message
import ifound.feature.recover_password.generated.resources.verification_code_sent_to_your_email_message
import ifound.feature.recover_password.generated.resources.verify
import ifound.feature.recover_password.generated.resources.verify_your_email_message
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ConfirmCodeScreen(
    onNavigateBack: () -> Unit,
    onNavigateToCreateNewPassword: () -> Unit
) {
    val viewModel = koinViewModel<ConfirmCodeViewModel>()
    val screenState = viewModel.state


    ConfirmCodeView(
        screenState = screenState,
        onFormEvent = viewModel::onEvent,
        onNavigateBack = onNavigateBack,
        onNavigateToCreateNewPassword = onNavigateToCreateNewPassword
    )
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ConfirmCodeView(
    screenState: ConfirmCodeScreenState,
    onFormEvent: (ConfirmCodeFormEvent) -> Unit,
    onNavigateBack: () -> Unit,
    onNavigateToCreateNewPassword: () -> Unit
) {

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopBarLeadingIconCenteredText(
                onLeadingIconClick = onNavigateBack
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .fillMaxSize()
                .padding(horizontal = Spacings.MARGIN_HORIZONTAL)
                .imePadding(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.weight(1f).fillMaxWidth().padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = stringResource(Res.string.verify_your_email_message),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = stringResource(Res.string.verification_code_sent_to_your_email_message),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
                CommonOtpTextField(
                    value = screenState.code,
                    onValueChange = {
                        onFormEvent(ConfirmCodeFormEvent.OnChangeCode(it))
                    }
                )
            }
            CommonButton(
                text = stringResource(Res.string.verify).capitalizeFirstLetter(),
                isLoading = screenState.isLoading,
                onClick = {
                    onFormEvent(ConfirmCodeFormEvent.OnSubmit(
                        onSuccess = {
                            onNavigateToCreateNewPassword()
                        }
                    ))
                }
            )
            Spacer(Modifier.height(7.dp))
            CommonTextButton(
                onClick = {
                    onFormEvent(ConfirmCodeFormEvent.OnRetrySendCode)
                },
                modifier = Modifier,
                enabled = !screenState.isLoading,
                leadingIcon = UiRes.Drawable.ic_email_sent,
                text = stringResource(Res.string.did_not_receive_email_resend_message),
            )
        }
    }
}

@Preview
@Composable
private fun ConfirmCodePreview() {
    IfoundTheme {
        ConfirmCodeView(
            screenState = ConfirmCodeScreenState(),
            onFormEvent = {},
            onNavigateBack = {},
            onNavigateToCreateNewPassword = {}
        )
    }
}
