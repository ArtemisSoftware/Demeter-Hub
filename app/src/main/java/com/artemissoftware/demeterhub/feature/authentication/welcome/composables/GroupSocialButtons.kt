package com.artemissoftware.demeterhub.feature.authentication.welcome.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.demeterhub.R
import com.artemissoftware.demeterhub.core.designsystem.dimension
import com.artemissoftware.demeterhub.core.designsystem.spacing
import com.artemissoftware.demeterhub.core.presentation.composables.button.SocialButton
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme


@Composable
internal fun GroupSocialButtons(
    onFacebookClicked: () -> Unit,
    onGoogleClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing2_5)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.spacing1),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f),
                thickness = MaterialTheme.dimension.dividerHeight,
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.sign_in_with),
                color = Color.White,
                modifier = Modifier.padding(MaterialTheme.spacing.spacing1)
            )
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f),
                thickness = MaterialTheme.dimension.dividerHeight,
                color = Color.White
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SocialButton(
                icon = R.drawable.ic_facebook,
                text = stringResource(id = R.string.sign_with_facebook),
                onClick = onFacebookClicked
            )
            SocialButton(
                icon = R.drawable.ic_google,
                text = stringResource(id = R.string.sign_with_google),
                onClick = onGoogleClicked
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun GroupSocialButtonsPreview() {
    DemeterHubTheme {
        GroupSocialButtons(
            modifier = Modifier.fillMaxWidth(),
            onFacebookClicked = {},
            onGoogleClicked = {}
        )
    }
}