package com.artemissoftware.demeterhub.feature.shop.data.mapper

import com.artemissoftware.demeterhub.core.data.remote.dto.shop.CategoryDto
import com.artemissoftware.demeterhub.core.data.remote.dto.shop.RestaurantDto
import com.artemissoftware.demeterhub.feature.shop.domain.models.Category
import com.artemissoftware.demeterhub.feature.shop.domain.models.Shop

fun CategoryDto.toCategory(): Category{
    return Category(
        createdAt = createdAt,
        id = id,
        imageUrl = imageUrl,
        name = name
    )
}

fun RestaurantDto.toShop(): Shop {
    return Shop(
        address = address,
        categoryId = categoryId,
        createdAt = createdAt,
        distance = distance,
        id = id,
        imageUrl = imageUrl,
        latitude = latitude,
        longitude = longitude,
        name = name,
        ownerId = ownerId
    )
}