package com.ifound.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val YellowPrimary = Color(0xFFFABF24)
val YellowSecondary = Color(0xFFA18745)

val WhiteSurface = Color(0xFFFCFAF7)
val WhiteSecondary = Color(0xFFF5F0E5) // inputs, buttons
val White = Color(0xFFFFFFFF)

val FontBlack = Color(0xFF1C170D)
val Black = Color(0xFF000000)
val GreenOpen = Color(0xFF008000)
val RedClose = Color(0xFF008000)

val GrayPrimary = Color(0xFFCBCFD6)
val GraySecondary = Color(0xFF555556)

val ifoundColors = lightColorScheme(
    primary = YellowPrimary,
    onPrimary = YellowSecondary,
    secondary = YellowSecondary,
    tertiary = WhiteSecondary,
    onTertiary = YellowSecondary,
    onSecondary = White,
    surface = WhiteSurface,
    onSurface = FontBlack,
    background = WhiteSurface,
    onBackground = FontBlack
)
