package com.artemissoftware.demeterhub.core.designsystem.composables.button

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.demeterhub.core.designsystem.dimension
import com.artemissoftware.demeterhub.core.designsystem.spacing
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme
import com.artemissoftware.demeterhub.ui.theme.Primary

@Composable
fun DHButton(
    text: String,
    onClick: () -> Unit,
    isLoading: Boolean = false,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(MaterialTheme.dimension.buttonHeightL),
        colors = ButtonDefaults.buttonColors(containerColor = Primary),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
    ) {
        Box {
            AnimatedContent(
                targetState = isLoading,
                transitionSpec = {
                    fadeIn(
                        animationSpec = tween(300)) + scaleIn(initialScale = 0.8f) togetherWith
                            fadeOut(animationSpec = tween(300)) + scaleOut(targetScale = 0.8f)
                }
            ) { target ->
                if (target) {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier
                            .padding(horizontal = MaterialTheme.spacing.spacing4)
                            .size(24.dp)
                    )
                } else {
                    Text(
                        text = text,
                        color = Color.White,
                        modifier = Modifier
                            .padding(horizontal = MaterialTheme.spacing.spacing4)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DHButtonPreview() {
    DemeterHubTheme {
        DHButton(
            onClick = {},
            text = "I am button"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DHButton_loading_Preview() {
    DemeterHubTheme {
        DHButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            text = "I am button",
            isLoading = true
        )
    }
}