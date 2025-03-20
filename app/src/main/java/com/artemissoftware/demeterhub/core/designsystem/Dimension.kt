package com.artemissoftware.demeterhub.core.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

data class Dimension(
    val buttonHeight: Dp,
    val iconSize: DpSize,
)

val dimensionPortrait = Dimension(
    buttonHeight = 38.dp,
    iconSize = DpSize(width = 24.dp, height = 24.dp),
)

internal val localDimension = staticCompositionLocalOf<Dimension> { throw IllegalStateException("No theme installed") }

val MaterialTheme.dimension: Dimension
    @Composable
    get() = localDimension.current