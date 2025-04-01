package com.artemissoftware.demeterhub.core.data.remote.dto.shop

import com.squareup.moshi.Json

data class CategoryDto(
    @field:Json(name = "createdAt")
    val createdAt: String,
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "imageUrl")
    val imageUrl: String,
    @field:Json(name = "name")
    val name: String
)
