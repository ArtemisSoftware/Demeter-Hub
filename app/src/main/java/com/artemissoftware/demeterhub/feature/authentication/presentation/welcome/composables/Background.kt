package com.artemissoftware.demeterhub.feature.authentication.presentation.welcome.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.artemissoftware.demeterhub.R
import com.artemissoftware.demeterhub.ui.theme.Black01
import com.artemissoftware.demeterhub.ui.theme.Black10
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme

@Composable
internal fun Background(modifier: Modifier = Modifier) {

    var imageSize by remember { mutableStateOf(IntSize.Zero) }

    val brush = Brush.verticalGradient(
        colors = listOf(
            Black01, Black10
        ),
        startY = imageSize.height.toFloat() / 3,
    )

    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier
                .onGloballyPositioned {
                    imageSize = it.size
                }
                .alpha(0.8f),
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(brush = brush)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BackgroundPreview() {
    DemeterHubTheme {
        Background(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}