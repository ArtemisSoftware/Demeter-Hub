package com.artemissoftware.demeterhub.core.data.remote.source

import com.artemissoftware.demeterhub.core.data.remote.HandleApi
import com.artemissoftware.demeterhub.core.data.remote.api.DemeterHubApi
import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.AuthenticationDto
import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.SignUpRequest
import javax.inject.Inject

class DemeterHubApiSource @Inject constructor(
    private val demeterHubApi: DemeterHubApi
) {
    suspend fun signUp(request: SignUpRequest): AuthenticationDto {
        return HandleApi.safeApiCall {
            demeterHubApi.signUp(request = request)
        }
    }
}