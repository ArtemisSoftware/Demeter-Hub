@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.artemissoftware.demeterhub.core.presentation.composables.sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.demeterhub.R
import com.artemissoftware.demeterhub.core.designsystem.composables.button.DHButton
import com.artemissoftware.demeterhub.core.designsystem.composables.button.DHButtonSize
import com.artemissoftware.demeterhub.core.designsystem.spacing
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme
import kotlinx.coroutines.launch


@Composable
fun DHErrorModalBottomSheet(
    showError: String? = null,
    modifier: Modifier = Modifier
) {
    val bottomSheetState = rememberModalBottomSheetState()
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = showError) {
        openBottomSheet = (showError != null)
    }

    if (openBottomSheet) {

        ModalBottomSheet(
            scrimColor =  Color.Black.copy(alpha = 0.3f),
            onDismissRequest = { openBottomSheet = false },
            sheetState = bottomSheetState,
            modifier = modifier
        ) {
            ErrorSheet(
                title = "Title",
                description = showError ?: "",
                onClick = {
                    scope
                        .launch { bottomSheetState.hide() }
                        .invokeOnCompletion {
                            if (!bottomSheetState.isVisible) {
                                openBottomSheet = false
                            }
                        }
                }
            )
        }
    }
}

@Composable
private fun ErrorSheet(
    title: String,
    description: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val bottomPadding =
        WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding().value.toInt() + 8

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.spacing2)
            .padding(bottom = bottomPadding.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.size(MaterialTheme.spacing.spacing1))

        Text(
            style = MaterialTheme.typography.bodyLarge,
            text = description,
        )

        Spacer(modifier = Modifier.size(MaterialTheme.spacing.spacing2))

        DHButton(
            height = DHButtonSize.SMALL,
            text = stringResource(id = R.string.ok),
            onClick = onClick
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ErrorSheetPreview() {
    DemeterHubTheme {
        ErrorSheet(
            "title",
            description = "Description",
            onClick = {}
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun DHErrorModalBottomSheetPreview() {

    var showError by remember { mutableStateOf<String?>(null) }

    DemeterHubTheme {
        Box {
            // App content
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                Button(
                    onClick = { showError = "THis is a mistake and an error" },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Show Bottom Sheet")
                }
            }

            DHErrorModalBottomSheet(
                modifier = Modifier.fillMaxWidth(),
                showError = showError
            )
        }
    }
}
