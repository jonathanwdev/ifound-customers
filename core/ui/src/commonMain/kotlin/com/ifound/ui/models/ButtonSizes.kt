package com.ifound.ui.models

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

enum class ButtonSizes(
    val padding: PaddingValues
) {
    SMALL(
        padding = PaddingValues(
            vertical = 5.dp,
            horizontal = 18.dp
        )
    ),
    FULL(
        padding = PaddingValues(
            vertical = 15.dp,
            horizontal = 24.dp
        )
    )
}