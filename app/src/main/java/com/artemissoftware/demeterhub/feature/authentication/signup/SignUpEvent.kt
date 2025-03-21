package com.artemissoftware.demeterhub.feature.authentication.signup

sealed interface SignUpEvent {
    data class UpdateName(val name: String): SignUpEvent
    data class UpdateEmail(val email: String): SignUpEvent
    data class UpdatePassword(val password: String): SignUpEvent
}