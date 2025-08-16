package com.ifound.recover_password.presentation.screens.passwordUpdated

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.ifound.ui.components.common.CommonButton
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import ifound.feature.recover_password.generated.resources.Res
import ifound.feature.recover_password.generated.resources.go_back_to_sign_in_message
import ifound.feature.recover_password.generated.resources.now_you_can_sign_in_with_new_password_message
import ifound.feature.recover_password.generated.resources.password_updated_success
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun PasswordUpdatedScreen(
    onGoBackToSignIn: () -> Unit,

    ) {
    PasswordUpdatedView(
        onGoBackToSignIn = onGoBackToSignIn,
    )
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun PasswordUpdatedView(
    onGoBackToSignIn: () -> Unit,
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .fillMaxSize()
                .padding(horizontal = Spacings.MARGIN_HORIZONTAL),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.weight(1f).fillMaxWidth().padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(Res.string.password_updated_success),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = stringResource(Res.string.now_you_can_sign_in_with_new_password_message),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
            }
            CommonButton(
                text = stringResource(Res.string.go_back_to_sign_in_message),
                onClick = onGoBackToSignIn
            )

        }

    }
}

@Preview
@Composable
private fun PasswordUpdatedPreview() {
    IfoundTheme {
        PasswordUpdatedView(
            onGoBackToSignIn = {},
        )
    }
}