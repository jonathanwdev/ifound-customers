package com.ifound.stores.presentation.screens.ourServices


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ifound.stores.presentation.components.StoreServiceCardItem
import com.ifound.ui.UiRes
import com.ifound.ui.components.common.CommonTextField
import com.ifound.ui.components.topBars.TopBarLeadingIconCenteredText
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun OurServicesScreen(
    onNavigateBack: () -> Unit,
    onNavigateToBookAppointment: () -> Unit,
) {
    OurServicesView(
        onNavigateBack = onNavigateBack,
        onNavigateToBookAppointment = onNavigateToBookAppointment
    )
}

@Composable
fun OurServicesView(
    onNavigateBack: () -> Unit,
    onNavigateToBookAppointment: () -> Unit,
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopBarLeadingIconCenteredText(
                title = "Our Services",
                icon = UiRes.Drawable.ic_arrow_back,
                onLeadingIconClick = {}
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .padding(
                    horizontal = Spacings.MARGIN_HORIZONTAL
                )
        ) {
            CommonTextField(
                value = "",
                onValueChange = {},
                placeholder = "Search",
                onTrailingIconClick = {},
                trailingIcon = UiRes.Drawable.ic_close_rounded,
                leadingIcon = UiRes.Drawable.ic_search
            )
            Spacer(Modifier.height(20.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(18.dp),
                contentPadding = PaddingValues(vertical = 10.dp)
            ) {
                items(count = 10) {
                    StoreServiceCardItem()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OurServicesViewPreview() {
    IfoundTheme {
        OurServicesView(
            onNavigateBack = {},
            onNavigateToBookAppointment = {}
        )
    }
}