package com.artemissoftware.demeterhub.feature.authentication.presentation.login

sealed interface LoginEvent {
    data class UpdateEmail(val email: String): LoginEvent
    data class UpdatePassword(val password: String): LoginEvent
    data object Login: LoginEvent
}