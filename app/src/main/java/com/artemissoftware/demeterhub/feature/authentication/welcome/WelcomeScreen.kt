package com.artemissoftware.demeterhub.feature.authentication.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.demeterhub.R
import com.artemissoftware.demeterhub.core.designsystem.spacing
import com.artemissoftware.demeterhub.feature.authentication.welcome.composables.Background
import com.artemissoftware.demeterhub.feature.authentication.welcome.composables.GroupSocialButtons
import com.artemissoftware.demeterhub.ui.theme.Black12
import com.artemissoftware.demeterhub.ui.theme.DemeterHubTheme
import com.artemissoftware.demeterhub.ui.theme.Primary

@Composable
fun WelcomeScreen(
    navigateToLogin: () -> Unit,
    navigateToSignUp: () -> Unit
) {
    WelcomeContent(
        navigateToLogin = navigateToLogin,
        navigateToSignUp = navigateToSignUp
    )
}

@Composable
private fun WelcomeContent(
    navigateToLogin: () -> Unit,
    navigateToSignUp: () -> Unit
) {
//    val sheetState = rememberModalBottomSheetState()
//    val scope = rememberCoroutineScope()
//    var showDialog by remember { mutableStateOf(false) }



//    LaunchedEffect(true) {
//        viewModel.navigationEvent.collectLatest { event ->
//            when (event) {
//                is AuthScreenViewModel.AuthNavigationEvent.NavigateToHome -> {
//                    navController.navigate(Home) {
//                        popUpTo(com.codewithfk.foodhub.ui.navigation.AuthScreen) {
//                            inclusive = true
//                        }
//                    }
//                }
//
//                is AuthScreenViewModel.AuthNavigationEvent.NavigateToSignUp -> {
//                    navController.navigate(SignUp)
//                }
//
//                is AuthScreenViewModel.AuthNavigationEvent.ShowErrorDialog -> {
//                    showDialog = true
//                }
//            }
//        }
//    }
//
    Box(modifier = Modifier.fillMaxSize()) {

        Background(modifier = Modifier.fillMaxSize())

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .align(
                    Alignment.TopEnd
                )
                .padding(26.dp)
        ) {
            Text(text = stringResource(id = R.string.skip), color = Primary)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.spacing20)
                .padding(horizontal = MaterialTheme.spacing.spacing2)
        ) {
            Text(
                text = stringResource(id = R.string.welcome),
                color = Color.Black,
                modifier = Modifier,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = R.string.demeter_hub),
                color = Primary,
                modifier = Modifier,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = stringResource(id = R.string.food_hub_desc),
                color = Black12,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth(0.85F)
                    .padding(vertical = MaterialTheme.spacing.spacing2)
            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(MaterialTheme.spacing.spacing2),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            if (isCustomer) {
            GroupSocialButtons(
                onFacebookClicked = { },
                onGoogleClicked = {},
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spacing3))

            Button(
                onClick = navigateToSignUp,
                modifier = Modifier.fillMaxWidth().height(54.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray.copy(alpha = 0.2f)),
                shape = RoundedCornerShape(32.dp),
                border = BorderStroke(1.dp, Color.White)
            ) {
                Text(text = stringResource(id = R.string.sign_with_email), color = Color.White)
            }

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spacing2))

            TextButton(
                onClick = navigateToLogin
            ) {
                Text(text = stringResource(id = R.string.alread_have_account), color = Color.White)
            }
        }



    }

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
private fun WelcomeContentPreview() {
    DemeterHubTheme {
        WelcomeContent(
            navigateToLogin = {},
            navigateToSignUp = {}
        )
    }
}