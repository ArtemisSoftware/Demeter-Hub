package com.artemissoftware.demeterhub.core.designsystem

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class Shapes(
    val noCorners: Shape,
    val buttonCorners: Shape
)

internal val shape = Shapes(
    noCorners = RoundedCornerShape(0),
    buttonCorners = RoundedCornerShape(32.dp),
)

internal val localShape = staticCompositionLocalOf<Shapes> { throw IllegalStateException("No theme installed") }

val MaterialTheme.shape: Shapes
    @Composable
    get() = localShape.current