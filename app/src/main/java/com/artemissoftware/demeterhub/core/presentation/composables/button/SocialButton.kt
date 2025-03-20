package com.artemissoftware.demeterhub.core.presentation.composables.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.demeterhub.R
import com.artemissoftware.demeterhub.core.designsystem.dimension
import com.artemissoftware.demeterhub.core.designsystem.shape
import com.artemissoftware.demeterhub.core.designsystem.spacing
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme

@Composable
fun SocialButton(
    icon: Int,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        shape = MaterialTheme.shape.buttonCorners,
    ) {
        Row(
            modifier = Modifier.height(MaterialTheme.dimension.buttonHeight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing1)
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(MaterialTheme.dimension.iconSize)
            )
            Text(
                text = text,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SocialButtonPreview() {
    DemeterHubTheme {
        SocialButton(
            icon = R.drawable.ic_launcher_foreground,
            text = "I am a button",
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}