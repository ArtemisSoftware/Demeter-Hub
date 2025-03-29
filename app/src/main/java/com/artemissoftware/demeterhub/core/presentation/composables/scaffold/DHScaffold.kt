@file:OptIn(ExperimentalMaterial3Api::class)

package com.artemissoftware.demeterhub.core.presentation.composables.scaffold

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.demeterhub.core.designsystem.spacing
import com.artemissoftware.demeterhub.core.presentation.composables.sheet.DHErrorModalBottomSheet
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme
import kotlinx.coroutines.launch

@Composable
fun DHScaffold(
    content: @Composable () -> Unit,
    background: @Composable () -> Unit = {},
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    showError: String? = null,
//    uiEvent: Flow<UiEvent>? = null,
//    errorState: ErrorState? = null
) {



//    val snackbarHostState = remember { SnackbarHostState() }
//
//    LaunchedEffect(key1 = Unit) {
//        uiEvent?.collectLatest { event ->
//            when (event) {
//                is UiEvent.Snackbar -> { event.value.showSnackbarEvent(snackbarHostState) }
//            }
//        }
//    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {


//        AnimatedVisibility(
//            visible = !isLoading,
//            enter = fadeIn(),
//            exit = fadeOut()
//        ) {
            Scaffold(
//                snackbarHost = { CustomSnackbarHost(snackbarHostState) },
                modifier = Modifier
                    .then(modifier),
                content = { innerPadding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {

                            background.invoke()
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = MaterialTheme.spacing.spacing3_5)
                                    .padding(bottom = MaterialTheme.spacing.spacing3_5)
                            ) {
                                content.invoke()
                                DHErrorModalBottomSheet(
                                    showError = showError,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                    }
                },
            )
//        }
//        AnimatedVisibility(
//            visible = errorState != null,
//            enter = slideInHorizontally(),
//            exit = fadeOut()
//        ) {
//            errorState?.let {
//                ErrorScreen(error = it)
//            }
//        }

//        if(isLoading)
//            CircularProgressIndicator(
//                modifier = Modifier.align(Alignment.Center)
//            )
    }
}

@Preview
@Composable
private fun CustomScaffoldPreview() {
    DemeterHubTheme {
        var showError by remember { mutableStateOf<String?>(null) }

//        var isLoading by remember { mutableStateOf(false) }
//        val scope = rememberCoroutineScope()
//
//        LaunchedEffect(isLoading) {
//            if(isLoading){
//                delay(2.seconds)
//                isLoading = !isLoading
//            }
//        }
//
//        var errorState by remember { mutableStateOf<ErrorState?>(null) }
//        val error = ErrorState(
//            title = "You arrived at an error screen",
//            onFinish = { errorState = null }
//        )
//
//        var index by remember { mutableIntStateOf(1) }
//
//        val lolo: Flow<UiEvent.Snackbar> = flowOf(UiEvent.Snackbar(CustomSnackbar.Success("I am the success $index")))
//        val snackbarFlow  = remember { MutableSharedFlow<UiEvent.Snackbar>() }

        DHScaffold(
//            uiEvent = snackbarFlow,
//            isLoading = isLoading,
//            errorState = errorState,
            showError = showError,
            content = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("I am the scaffold")

                    Text("showError = $showError")
                    Button(
                        onClick = { showError = "THis is a mistake and an error" },
                        content = {
                            Text("Toggle error modal")
                        }
                    )
//                    Button(
//                        onClick = { isLoading = !isLoading },
//                        content = {
//                            Text("Toggle is loading")
//                        }
//                    )
//                    Button(
//                        onClick = {
//                            errorState = error
//                        },
//                        content = {
//                            Text("Toggle error")
//                        }
//                    )
//                    Button(
//                        onClick = {
//                            scope.launch {
//                                snackbarFlow.emit(UiEvent.Snackbar(CustomSnackbar.Success("I am the success $index")))
//                            }
//
//                            ++index
//                        },
//                        content = {
//                            Text("Toggle Snack")
//                        }
//                    )
                }
            },
        )
    }
}