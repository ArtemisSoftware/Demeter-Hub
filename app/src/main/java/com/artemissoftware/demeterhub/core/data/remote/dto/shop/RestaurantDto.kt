package com.artemissoftware.demeterhub.core.data.remote.dto.shop

import com.squareup.moshi.Json

data class RestaurantDto(
    @field:Json(name = "address")
    val address: String,
    @field:Json(name = "categoryId")
    val categoryId: String,
    @field:Json(name = "createdAt")
    val createdAt: String,
    @field:Json(name = "distance")
    val distance: Double,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "imageUrl")
    val imageUrl: String,
    @field:Json(name = "latitude")
    val latitude: Double,
    @field:Json(name = "longitude")
    val longitude: Double,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "ownerId")
    val ownerId: String
)
