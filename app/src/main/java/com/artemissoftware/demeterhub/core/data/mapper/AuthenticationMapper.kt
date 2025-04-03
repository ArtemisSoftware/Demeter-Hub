package com.artemissoftware.demeterhub.core.data.mapper

import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.AuthenticationDto
import com.artemissoftware.demeterhub.core.domain.models.Authentication

fun AuthenticationDto.toAuthentication(): Authentication {
    return Authentication(
        token = token
    )
}