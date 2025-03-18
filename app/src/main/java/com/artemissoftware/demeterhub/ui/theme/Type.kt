package com.artemissoftware.demeterhub.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.artemissoftware.demeterhub.R

val PoppinsFontFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_thin, FontWeight.Thin),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_extra_light, FontWeight.ExtraLight),
    Font(R.font.poppins_black, FontWeight.Black)
)
val baseline = Typography()
// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = PoppinsFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = PoppinsFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = PoppinsFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = PoppinsFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = PoppinsFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = PoppinsFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = PoppinsFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = PoppinsFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = PoppinsFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = PoppinsFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = PoppinsFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = PoppinsFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = PoppinsFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = PoppinsFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = PoppinsFontFamily),
)