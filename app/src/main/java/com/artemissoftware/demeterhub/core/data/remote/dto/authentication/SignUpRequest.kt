package com.artemissoftware.demeterhub.core.data.remote.dto.authentication

data class SignUpRequest(
    val name: String,
    val email: String,
    val password: String
)
