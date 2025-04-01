package com.artemissoftware.demeterhub.core.designsystem

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class Shapes(
    val noCorners: Shape,
    val buttonCorners: Shape,
    val textFieldCorners: Shape,
    val ratingPillShape: Shape,
    val categoryPillShape: Shape,
    val categoryPillImageShape: Shape,
    val shopCardShape: Shape
)

internal val shape = Shapes(
    noCorners = RoundedCornerShape(0),
    buttonCorners = RoundedCornerShape(32.dp),
    textFieldCorners = RoundedCornerShape(10.dp),
    ratingPillShape = RoundedCornerShape(32.dp),
    categoryPillShape = RoundedCornerShape(45.dp),
    categoryPillImageShape = RoundedCornerShape(50.dp),
    shopCardShape = RoundedCornerShape(16.dp)
)

internal val localShape = staticCompositionLocalOf<Shapes> { throw IllegalStateException("No theme installed") }

val MaterialTheme.shape: Shapes
    @Composable
    get() = localShape.current