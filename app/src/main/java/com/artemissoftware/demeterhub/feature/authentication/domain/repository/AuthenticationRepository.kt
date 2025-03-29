package com.artemissoftware.demeterhub.feature.authentication.domain.repository

import com.artemissoftware.demeterhub.core.domain.Resource
import com.artemissoftware.demeterhub.feature.authentication.domain.models.Authentication

interface AuthenticationRepository {
    suspend fun signUp(name: String, email: String, password: String): Resource<Authentication>
    suspend fun login(email: String, password: String): Resource<Authentication>
}