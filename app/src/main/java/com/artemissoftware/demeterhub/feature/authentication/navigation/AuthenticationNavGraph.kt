package com.artemissoftware.demeterhub.feature.authentication.navigation

import android.annotation.SuppressLint
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.artemissoftware.demeterhub.feature.authentication.signup.SignUpScreen
import com.artemissoftware.demeterhub.feature.authentication.welcome.WelcomeScreen


@SuppressLint("ComposableDestinationInComposeScope")
fun NavGraphBuilder.authenticationNavGraph(
    navController: NavHostController,
) {

    composable<AuthenticationRoute.Welcome> {
        WelcomeScreen(
            navigateToLogin = {},
            navigateToSignUp = {}
        )
    }

    composable<AuthenticationRoute.SignUp> {
        SignUpScreen()
    }
}