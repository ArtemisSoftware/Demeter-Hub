package com.artemissoftware.demeterhub.feature.authentication.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.artemissoftware.demeterhub.R
import com.artemissoftware.demeterhub.core.designsystem.composables.button.DHButton
import com.artemissoftware.demeterhub.core.designsystem.composables.textfield.DHTextField
import com.artemissoftware.demeterhub.core.designsystem.dimension
import com.artemissoftware.demeterhub.core.designsystem.spacing
import com.artemissoftware.demeterhub.core.presentation.composables.event.ManageUIEvents
import com.artemissoftware.demeterhub.core.presentation.composables.scaffold.DHScaffold
import com.artemissoftware.demeterhub.feature.authentication.presentation.composables.GroupSocialButtons
import com.artemissoftware.demeterhub.feature.authentication.presentation.navigation.AuthenticationRoute
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme
import com.artemissoftware.demeterhub.ui.theme.Grey1

@Composable
internal fun LoginScreen(
    navigateToSignUp: () -> Unit,
    navigateToHome: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    LoginContent(
        state = state,
        onEvent = viewModel::onTriggerEvent,
        navigateToSignUp = navigateToSignUp
    )

    ManageUIEvents(
        uiEvent = viewModel.uiEvent,
        onNavigateWithRoute = {
            when(it.value){
                is AuthenticationRoute.Home -> navigateToHome()
                else -> Unit
            }
        }
    )
}

@Composable
private fun LoginContent(
    state: LoginState,
    navigateToSignUp: () -> Unit,
    onEvent: (LoginEvent) -> Unit
) {

    DHScaffold(
        errorInfo = state.errorInfo,
        background = {
            Image(
                painter = painterResource(id = R.drawable.ic_auth_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        },
        content =  {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.login),
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.size(MaterialTheme.spacing.spacing1_5))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing1)
                    ) {
                        DHTextField(
                            value = state.email,
                            enabled = !state.isLoading,
                            onValueChange = { onEvent(LoginEvent.UpdateEmail(it)) },
                            label = stringResource(id = R.string.email),
                            modifier = Modifier.fillMaxWidth()
                        )
                        DHTextField(
                            value = state.password,
                            enabled = !state.isLoading,
                            onValueChange = { onEvent(LoginEvent.UpdatePassword(it)) },
                            label = stringResource(id = R.string.password),
                            modifier = Modifier.fillMaxWidth(),
                            visualTransformation = PasswordVisualTransformation(),
                            trailingIcon = {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_eye),
                                    contentDescription = null,
                                    modifier = Modifier.size(MaterialTheme.dimension.iconSize)
                                )
                            }
                        )
                    }

                    Spacer(modifier = Modifier.size(MaterialTheme.spacing.spacing1_5))

                    DHButton(
                        text = stringResource(id = R.string.sign_up),
                        onClick = { onEvent(LoginEvent.Login) },
                        isLoading = state.isLoading,
                    )

                    Spacer(modifier = Modifier.size(MaterialTheme.spacing.spacing1_5))

                    Text(
                        text = stringResource(id = R.string.dont_have_account),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(MaterialTheme.spacing.spacing1)
                            .clickable {
                                navigateToSignUp()
                            },
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.size(40.dp))

                    GroupSocialButtons(
                        textColor = Color.Black,
                        dividerColor = Grey1,
                        onFacebookClicked = {},
                        onGoogleClicked = {},
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

        }
    )
//    val email = viewModel.email.collectAsStateWithLifecycle()
//    val password = viewModel.password.collectAsStateWithLifecycle()
//    val errorMessage = remember { mutableStateOf<String?>(null) }
//    val loading = remember { mutableStateOf(false) }
//    val sheetState = rememberModalBottomSheetState()
//    val scope = rememberCoroutineScope()
//    var showDialog by remember { mutableStateOf(false) }
//    LaunchedEffect(errorMessage.value) {
//        if (errorMessage.value != null)
//            scope.launch {
//                showDialog = true
//            }
//    }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//
//
//        val uiState = viewModel.uiState.collectAsState()
//        when (uiState.value) {
//
//            is SignInViewModel.SignInEvent.Error -> {
//                // show error
//                loading.value = false
//                errorMessage.value = "Failed"
//            }
//
//            is SignInViewModel.SignInEvent.Loading -> {
//                loading.value = true
//                errorMessage.value = null
//            }
//
//            else -> {
//                loading.value = false
//                errorMessage.value = null
//            }
//        }
//        val context = LocalContext.current
//        LaunchedEffect(true) {
//            viewModel.navigationEvent.collectLatest { event ->
//                when (event) {
//                    is SignInViewModel.SigInNavigationEvent.NavigateToHome -> {
//                        navController.navigate(Home) {
//                            popUpTo(AuthScreen) {
//                                inclusive = true
//                            }
//                        }
//                    }
//
//                    is SignInViewModel.SigInNavigationEvent.NavigateToSignUp -> {
//                        navController.navigate(SignUp)
//                    }
//                }
//            }
//        }
//
//        Image(
//            painter = painterResource(id = R.drawable.ic_auth_bg),
//            contentDescription = null,
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.FillBounds
//        )
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
//        ) {
//            Box(modifier = Modifier.weight(1f))
//            Text(
//                text = stringResource(id = R.string.sign_in),
//                fontSize = 32.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.size(20.dp))
//            FoodHubTextField(
//                value = email.value,
//                onValueChange = { viewModel.onEmailChange(it) },
//                label = {
//                    Text(text = stringResource(id = R.string.email), color = Color.Gray)
//                },
//                modifier = Modifier.fillMaxWidth()
//            )
//            FoodHubTextField(
//                value = password.value,
//                onValueChange = { viewModel.onPasswordChange(it) },
//                label = {
//                    Text(text = stringResource(id = R.string.password), color = Color.Gray)
//                },
//                modifier = Modifier.fillMaxWidth(),
//                visualTransformation = PasswordVisualTransformation(),
//                trailingIcon = {
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_eye),
//                        contentDescription = null,
//                        modifier = Modifier.size(24.dp)
//                    )
//                }
//            )
//            Spacer(modifier = Modifier.size(16.dp))
//            Text(text = errorMessage.value ?: "", color = Color.Red)
//            Button(
//                onClick = viewModel::onSignInClick, modifier = Modifier.height(48.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Orange)
//            ) {
//                Box {
//                    AnimatedContent(targetState = loading.value,
//                        transitionSpec = {
//                            fadeIn(animationSpec = tween(300)) + scaleIn(initialScale = 0.8f) togetherWith
//                                    fadeOut(animationSpec = tween(300)) + scaleOut(targetScale = 0.8f)
//                        }
//                    ) { target ->
//                        if (target) {
//                            CircularProgressIndicator(
//                                color = Color.White,
//                                modifier = Modifier
//                                    .padding(horizontal = 32.dp)
//                                    .size(24.dp)
//                            )
//                        } else {
//                            Text(
//                                text = stringResource(id = R.string.sign_in),
//                                color = Color.White,
//                                modifier = Modifier.padding(horizontal = 32.dp)
//                            )
//                        }
//
//                    }
//
//
//                }
//            }
//            Spacer(modifier = Modifier.size(16.dp))
//            Text(
//                text = stringResource(id = R.string.dont_have_account),
//                modifier = Modifier
//                    .padding(8.dp)
//                    .clickable {
//                        viewModel.onSignUpClicked()
//                    }
//                    .fillMaxWidth(),
//                textAlign = TextAlign.Center
//            )
//            val context = LocalContext.current
//            GroupSocialButtons(
//                color = Color.Black,
//                viewModel = viewModel,
//            )
//        }
//    }
//    if (showDialog) {
//        ModalBottomSheet(onDismissRequest = { showDialog = false }, sheetState = sheetState) {
//            BasicDialog(
//                title = viewModel.error,
//                description = viewModel.errorDescription,
//                onClick = {
//                    scope.launch {
//                        sheetState.hide()
//                        showDialog = false
//                    }
//                }
//            )
//        }
//    }
}

@Preview(showBackground = true)
@Composable
private fun SignInContentPreview() {
    DemeterHubTheme {
        LoginContent(
            state = LoginState(),
            onEvent = {},
            navigateToSignUp = {}
        )
    }
}