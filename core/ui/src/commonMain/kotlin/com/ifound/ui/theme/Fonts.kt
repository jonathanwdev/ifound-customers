package com.ifound.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import ifound.core.ui.generated.resources.Montserrat_Light
import ifound.core.ui.generated.resources.Montserrat_Medium
import ifound.core.ui.generated.resources.Montserrat_Regular
import ifound.core.ui.generated.resources.Montserrat_Bold
import ifound.core.ui.generated.resources.Montserrat_SemiBold
import ifound.core.ui.generated.resources.Res
import org.jetbrains.compose.resources.Font


@Composable
fun montserratFontFaily() = FontFamily(
    Font(resource = Res.font.Montserrat_Bold, weight = FontWeight.Bold),
    Font(resource = Res.font.Montserrat_SemiBold, weight = FontWeight.SemiBold),
    Font(resource = Res.font.Montserrat_Regular, weight = FontWeight.Normal),
    Font(resource = Res.font.Montserrat_Medium, weight = FontWeight.Medium),
    Font(resource = Res.font.Montserrat_Light, weight = FontWeight.Light),
)


@Composable
fun appTypography() = Typography().run {
    val fontFamily = montserratFontFaily()

    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily),
    )
}


