@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.artemissoftware.demeterhub.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.artemissoftware.demeterhub.core.presentation.navigation.transitions.enterTransition
import com.artemissoftware.demeterhub.core.presentation.navigation.transitions.exitTransition
import com.artemissoftware.demeterhub.core.presentation.navigation.transitions.popEnterTransition
import com.artemissoftware.demeterhub.core.presentation.navigation.transitions.popExitTransition
import com.artemissoftware.demeterhub.feature.authentication.presentation.navigation.AuthenticationRoute
import com.artemissoftware.demeterhub.feature.authentication.presentation.navigation.authenticationNavGraph

@Composable
fun RootNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: Any = AuthenticationRoute.Welcome,
) {
    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            enterTransition = enterTransition(),
            exitTransition = exitTransition(),
            popEnterTransition = popEnterTransition(),
            popExitTransition = popExitTransition(),
            modifier = modifier
        ) {
            authenticationNavGraph(
                navController = navController,
            )
        }
    }
}
