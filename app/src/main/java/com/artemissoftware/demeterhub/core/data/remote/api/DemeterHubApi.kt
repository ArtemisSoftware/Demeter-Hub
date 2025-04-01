package com.artemissoftware.demeterhub.core.data.remote.api

import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.AuthenticationDto
import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.LogInRequest
import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.SignUpRequest
import com.artemissoftware.demeterhub.core.data.remote.dto.shop.CategoryDto
import com.artemissoftware.demeterhub.core.data.remote.dto.shop.RestaurantDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DemeterHubApi {

    @POST("/auth/signup")
    suspend fun signUp(@Body request: SignUpRequest): AuthenticationDto

    @POST("/auth/login")
    suspend fun login(@Body request: LogInRequest): AuthenticationDto

    @GET("/categories")
    suspend fun getCategories(): List<CategoryDto>

    @GET("/restaurants")
    suspend fun getRestaurants(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): List<RestaurantDto>


    companion object {
        const val BASE_URL = "Http://www.food.ag"
    }
}