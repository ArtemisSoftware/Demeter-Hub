package com.artemissoftware.demeterhub.core.data.remote.source

import com.artemissoftware.demeterhub.core.data.remote.HandleApi
import com.artemissoftware.demeterhub.core.data.remote.api.DemeterHubApi
import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.AuthenticationDto
import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.LogInRequest
import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.SignUpRequest
import com.artemissoftware.demeterhub.core.data.remote.dto.shop.CategoryDto
import com.artemissoftware.demeterhub.core.data.remote.dto.shop.RestaurantDto
import javax.inject.Inject

class DemeterHubApiSource @Inject constructor(
    private val demeterHubApi: DemeterHubApi
) {
    suspend fun signUp(request: SignUpRequest): AuthenticationDto {
        return HandleApi.safeApiCall {
            demeterHubApi.signUp(request = request)
        }
    }

    suspend fun login(request: LogInRequest): AuthenticationDto {
        return HandleApi.safeApiCall {
            demeterHubApi.login(request = request)
        }
    }

    suspend fun getCategories(): List<CategoryDto> {
        return HandleApi.safeApiCall {
            demeterHubApi.getCategories()
        }
    }

    suspend fun getRestaurants(latitude: Double, longitude: Double): List<RestaurantDto> {
        return HandleApi.safeApiCall {
            demeterHubApi.getRestaurants(lat = latitude, lon = longitude)
        }
    }
}