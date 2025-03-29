package com.artemissoftware.demeterhub.core.designsystem.composables.button

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.artemissoftware.demeterhub.core.designsystem.composables.button.DHButtonSize.NORMAL
import com.artemissoftware.demeterhub.core.designsystem.composables.button.DHButtonSize.SMALL
import com.artemissoftware.demeterhub.core.designsystem.dimension

enum class DHButtonSize {
    NORMAL,
    SMALL;
}

@Composable
fun DHButtonSize.toDp(): Dp{
    return when(this){
        NORMAL -> MaterialTheme.dimension.buttonHeightLarge
        SMALL ->  MaterialTheme.dimension.buttonHeight
    }
}