package com.artemissoftware.demeterhub.feature.authentication.presentation.navigation

import kotlinx.serialization.Serializable

sealed class AuthenticationRoute {
    @Serializable
    object Welcome

    @Serializable
    object SignUp

    @Serializable
    object Home

    @Serializable
    object Login
}