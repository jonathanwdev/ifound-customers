package com.ifound.stores.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ifound.stores.presentation.components.CategoryButton
import com.ifound.stores.presentation.components.HomeTopBar
import com.ifound.stores.presentation.components.MainBottomBar
import com.ifound.stores.presentation.components.StoreMainCardItem
import com.ifound.ui.UiRes
import com.ifound.ui.components.common.CommonTextField
import com.ifound.ui.theme.IfoundTheme
import com.ifound.ui.theme.Spacings
import ifound.feature.stores.generated.resources.Res
import ifound.feature.stores.generated.resources.search_stores
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    onNavigateToStoreDetail: () -> Unit
) {
    HomeView(
        onNavigateToStoreDetail = onNavigateToStoreDetail
    )
}


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomeView(
    onNavigateToStoreDetail: () -> Unit
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            HomeTopBar(
                title = "San Francisco, CA ·",
                onLeftIconClick = {},
            )
        },
        bottomBar = {
            MainBottomBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .padding(horizontal = Spacings.MARGIN_HORIZONTAL)
                .padding(top = 8.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Find and book\nthe best services",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(Modifier.height(12.dp))
            CommonTextField(
                value = "",
                onValueChange = {},
                placeholder = stringResource(Res.string.search_stores),
                leadingIcon = UiRes.Drawable.ic_search,
                trailingIcon = UiRes.Drawable.ic_close_rounded
            )
            Spacer(Modifier.height(12.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(10) { size ->
                    CategoryButton()
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                contentPadding = PaddingValues(vertical = 10.dp)
            ) {
                items(10) { size ->
                    StoreMainCardItem(
                        onItemClick = onNavigateToStoreDetail
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    IfoundTheme {
        HomeView(
            onNavigateToStoreDetail = {}
        )
    }
}