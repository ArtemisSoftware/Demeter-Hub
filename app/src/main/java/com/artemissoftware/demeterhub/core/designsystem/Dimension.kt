package com.artemissoftware.demeterhub.core.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

data class Dimension(
    val socialButtonHeight: Dp,
    val buttonHeight: Dp,
    val buttonHeightLarge: Dp,
    val iconSize: DpSize,
    val iconSizeMedium: DpSize,
    val dividerHeight: Dp,
)

val dimensionPortrait = Dimension(
    socialButtonHeight = 38.dp,
    buttonHeight = 48.dp,
    buttonHeightLarge = 58.dp,
    iconSize = DpSize(width = 24.dp, height = 24.dp),
    iconSizeMedium = DpSize(width = 28.dp, height = 28.dp),
    dividerHeight = 1.dp,
)

internal val localDimension = staticCompositionLocalOf<Dimension> { throw IllegalStateException("No theme installed") }

val MaterialTheme.dimension: Dimension
    @Composable
    get() = localDimension.current