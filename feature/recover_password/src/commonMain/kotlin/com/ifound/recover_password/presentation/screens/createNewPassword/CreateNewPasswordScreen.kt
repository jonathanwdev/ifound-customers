package com.ifound.recover_password.presentation.screens.createNewPassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ifound.ui.UiRes
import com.ifound.ui.components.common.CommonButton
import com.ifound.ui.components.common.CommonTextField
import com.ifound.ui.components.topBars.TopBarGoback
import com.ifound.ui.helpers.stringHelpers.capitalizeFirstLetter
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import ifound.feature.recover_password.generated.resources.Res
import ifound.feature.recover_password.generated.resources.confirm
import ifound.feature.recover_password.generated.resources.create_new_password_message
import ifound.feature.recover_password.generated.resources.never_share_password_message
import ifound.feature.recover_password.generated.resources.new_password
import ifound.feature.recover_password.generated.resources.password_confirmation
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun CreateNewPasswordScreen(
    onNavigateBack: () -> Unit,
    onNavigateToPasswordUpdated: () -> Unit
) {
    CreateNewPasswordView(
        onNavigateBack = onNavigateBack,
        onNavigateToPasswordUpdated = onNavigateToPasswordUpdated
    )
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun CreateNewPasswordView(
    onNavigateBack: () -> Unit,
    onNavigateToPasswordUpdated: () -> Unit
) {

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopBarGoback(
                onGoBackClick = onNavigateBack
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
                    text = stringResource(Res.string.create_new_password_message),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = stringResource(Res.string.never_share_password_message),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
                CommonTextField(
                    onValueChange = { },
                    value = "",
                    leadingIcon = UiRes.Drawable.ic_lock,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    placeholder = stringResource(Res.string.new_password).capitalizeFirstLetter()
                )
                CommonTextField(
                    onValueChange = { },
                    value = "",
                    leadingIcon = UiRes.Drawable.ic_lock,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    placeholder = stringResource(Res.string.password_confirmation).capitalizeFirstLetter()
                )
            }
            CommonButton(
                text = stringResource(Res.string.confirm).capitalizeFirstLetter(),
                onClick = onNavigateToPasswordUpdated
            )
        }
    }
}

@Preview
@Composable
private fun ConfirmCodePreview() {
    IfoundTheme {
        CreateNewPasswordView(
            onNavigateBack = {},
            onNavigateToPasswordUpdated = {}
        )
    }
}
