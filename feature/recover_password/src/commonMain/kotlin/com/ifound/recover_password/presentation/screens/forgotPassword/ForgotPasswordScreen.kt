package com.ifound.recover_password.presentation.screens.forgotPassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.ifound.ui.components.common.CommonTextField
import com.ifound.ui.components.topBars.TopBarCancel
import com.ifound.ui.helpers.stringHelpers.capitalizeFirstLetter
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import ifound.feature.recover_password.generated.resources.Res
import ifound.feature.recover_password.generated.resources.email
import ifound.feature.recover_password.generated.resources.forgot_password_sign_in_message
import ifound.feature.recover_password.generated.resources.insert_your_email_to_recover_password_message
import ifound.feature.recover_password.generated.resources.send
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ForgotPasswordScreen(
    onNavigateBack: () -> Unit,
    onNavigateToConfirmCode: () -> Unit
) {
    ForgotPasswordView(
        onNavigateBack = onNavigateBack,
        onNavigateToConfirmCode = onNavigateToConfirmCode
    )
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ForgotPasswordView(
    onNavigateBack: () -> Unit,
    onNavigateToConfirmCode: () -> Unit
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopBarCancel(
                onCancelClick = onNavigateBack
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
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = stringResource(Res.string.forgot_password_sign_in_message),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = stringResource(Res.string.insert_your_email_to_recover_password_message),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
                CommonTextField(
                    onValueChange = {},
                    value = "",
                    leadingIcon = UiRes.Drawable.ic_at,
                    placeholder = stringResource(Res.string.email).capitalizeFirstLetter()
                )
            }
            CommonButton(
                text = stringResource(Res.string.send).capitalizeFirstLetter(),
                onClick = onNavigateToConfirmCode
            )
        }
    }
}

@Preview
@Composable
private fun ForgotPasswordPreview() {
    IfoundTheme {
        ForgotPasswordView(
            onNavigateBack = {},
            onNavigateToConfirmCode =  {}
        )
    }
}