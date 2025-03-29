package com.artemissoftware.demeterhub.core.data.remote.api

import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.AuthenticationDto
import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.LogInRequest
import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface DemeterHubApi {

    @POST("/auth/signup")
    suspend fun signUp(@Body request: SignUpRequest): AuthenticationDto

    @POST("/auth/login")
    suspend fun login(@Body request: LogInRequest): AuthenticationDto

    companion object {
        const val BASE_URL = "Http://www.food.ag"
    }
}