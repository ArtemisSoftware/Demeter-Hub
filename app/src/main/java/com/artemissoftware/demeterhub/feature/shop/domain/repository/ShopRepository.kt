package com.artemissoftware.demeterhub.feature.shop.domain.repository

import com.artemissoftware.demeterhub.core.domain.Resource
import com.artemissoftware.demeterhub.feature.shop.domain.models.Dashboard

interface ShopRepository {
    suspend fun getDashboard(latitude: Double, longitude: Double): Resource<Dashboard>
}