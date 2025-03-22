package com.artemissoftware.demeterhub.core.data.remote.dto.authentication

import com.squareup.moshi.Json

data class AuthenticationDto(
    @field:Json(name = "token")
    val token: String
)