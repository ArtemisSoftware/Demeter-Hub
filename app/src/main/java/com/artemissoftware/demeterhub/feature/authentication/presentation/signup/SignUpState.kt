package com.artemissoftware.demeterhub.feature.authentication.presentation.signup

data class SignUpState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val name: String = "",
    val error: String? = null,
)
