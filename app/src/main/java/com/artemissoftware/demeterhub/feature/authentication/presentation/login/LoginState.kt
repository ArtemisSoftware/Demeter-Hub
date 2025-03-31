package com.artemissoftware.demeterhub.feature.authentication.presentation.login

import com.artemissoftware.demeterhub.core.presentation.models.ErrorInfo

data class LoginState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val errorInfo: ErrorInfo? = null,
)
