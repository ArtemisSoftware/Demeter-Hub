package com.artemissoftware.demeterhub.feature.authentication.presentation.signup

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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.artemissoftware.demeterhub.core.presentation.composables.scaffold.DHScaffold
import com.artemissoftware.demeterhub.core.designsystem.composables.textfield.DHTextField
import com.artemissoftware.demeterhub.core.designsystem.dimension
import com.artemissoftware.demeterhub.core.designsystem.spacing
import com.artemissoftware.demeterhub.core.presentation.composables.event.ManageUIEvents
import com.artemissoftware.demeterhub.feature.authentication.presentation.composables.GroupSocialButtons
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme
import com.artemissoftware.demeterhub.ui.theme.Grey1

@Composable
fun SignUpScreen(
    navigateToLogin: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
){

    val state = viewModel.state.collectAsStateWithLifecycle().value

    SignUpContent(
        state = state,
        onEvent = viewModel::onTriggerEvent,
        navigateToLogin = navigateToLogin
    )

    ManageUIEvents(
       uiEvent = viewModel.uiEvent,
        onNavigateWithRoute = {

        }
    )
}

@Composable
private fun SignUpContent(
    state: SignUpState,
    onEvent: (SignUpEvent) -> Unit,
    navigateToLogin: () -> Unit
) {



//        val context = LocalContext.current
//        LaunchedEffect(true) {
//            viewModel.navigationEvent.collectLatest { event ->
//                when (event) {
//                    is SignUpViewModel.SigupNavigationEvent.NavigateToHome -> {
//                        navController.navigate(Home) {
//                            popUpTo(AuthScreen) {
//                                inclusive = true
//                            }
//                        }
//                    }
//
//                    is SignUpViewModel.SigupNavigationEvent.NavigateToLogin -> {
//                        navController.navigate(Login)
//                    }
//                }
//            }
//        }

    DHScaffold(
        modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing3_5),
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
                        text = stringResource(id = R.string.sign_up),
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
                            value = state.name,
                            enabled = !state.isLoading,
                            onValueChange = { onEvent(SignUpEvent.UpdateName(it)) },
                            label = stringResource(id = R.string.full_name),
                            modifier = Modifier.fillMaxWidth()
                        )
                        DHTextField(
                            value = state.email,
                            enabled = !state.isLoading,
                            onValueChange = { onEvent(SignUpEvent.UpdateEmail(it)) },
                            label = stringResource(id = R.string.email),
                            modifier = Modifier.fillMaxWidth()
                        )
                        DHTextField(
                            value = state.password,
                            enabled = !state.isLoading,
                            onValueChange = { onEvent(SignUpEvent.UpdatePassword(it)) },
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
                        onClick = { onEvent(SignUpEvent.SignUp) },
                        isLoading = state.isLoading,
                    )

                    Spacer(modifier = Modifier.size(MaterialTheme.spacing.spacing1_5))

                    Text(
                        text = stringResource(id = R.string.alread_have_account),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navigateToLogin()
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
}

@Preview(showBackground = true)
@Composable
private fun SignUpContentPreview() {
    DemeterHubTheme {
        SignUpContent(state = SignUpState(), onEvent = {}, navigateToLogin = {})
    }
}