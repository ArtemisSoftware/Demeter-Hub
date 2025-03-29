package com.artemissoftware.demeterhub.feature.authentication.presentation.signup

import com.artemissoftware.demeterhub.core.presentation.models.ErrorInfo

data class SignUpState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val name: String = "",
    val errorInfo: ErrorInfo? = null,
)
