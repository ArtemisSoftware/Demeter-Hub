package com.artemissoftware.demeterhub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.artemissoftware.demeterhub.feature.authentication.navigation.AuthenticationRoute
import com.artemissoftware.demeterhub.feature.authentication.navigation.authenticationNavGraph

@Composable
fun RootNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: Any = AuthenticationRoute.Welcome,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        authenticationNavGraph(
            navController = navController,
        )
    }
}