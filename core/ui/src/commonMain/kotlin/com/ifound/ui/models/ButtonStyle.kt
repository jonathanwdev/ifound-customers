package com.ifound.ui.models

import androidx.compose.ui.graphics.Color
import com.ifound.ui.theme.FontBlack
import com.ifound.ui.theme.White
import com.ifound.ui.theme.WhiteSecondary
import com.ifound.ui.theme.WhiteSurface
import com.ifound.ui.theme.YellowPrimary
import com.ifound.ui.theme.YellowSecondary


enum class ButtonStyle(
    val first: Color,
    val second: Color
) {
    Primary(
        first = YellowPrimary,
        second = WhiteSurface
    ),
    Secondary(
        first = WhiteSecondary,
        second = FontBlack
    ),
    Tertiary(
        first = White,
        second = YellowSecondary
    ),
}