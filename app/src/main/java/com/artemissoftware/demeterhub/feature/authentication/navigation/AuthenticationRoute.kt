package com.artemissoftware.demeterhub.feature.authentication.navigation

import kotlinx.serialization.Serializable

sealed class AuthenticationRoute {
    @Serializable
    object Welcome

    @Serializable
    object SignUp
}