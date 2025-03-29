package com.artemissoftware.demeterhub.feature.authentication.presentation.navigation

import android.annotation.SuppressLint
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.artemissoftware.demeterhub.feature.authentication.presentation.signup.SignUpScreen
import com.artemissoftware.demeterhub.feature.authentication.presentation.welcome.WelcomeScreen


@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.authenticationNavGraph(
    navController: NavHostController,
) {

    composable<AuthenticationRoute.Welcome> {
        WelcomeScreen(
            navigateToLogin = {},
            navigateToSignUp = {
                navController.navigate(AuthenticationRoute.SignUp)
            }
        )
    }

    composable<AuthenticationRoute.SignUp> {
        SignUpScreen(
            navigateToLogin = {}
        )
    }
}