package com.artemissoftware.demeterhub.feature.shop.domain.usecase

import com.artemissoftware.demeterhub.feature.shop.domain.repository.ShopRepository
import javax.inject.Inject

class GetDashboardUseCase @Inject constructor(
    private val repository: ShopRepository
) {
    suspend operator fun invoke(latitude: Double, longitude: Double) = repository.getDashboard(latitude = latitude, longitude = longitude)
}