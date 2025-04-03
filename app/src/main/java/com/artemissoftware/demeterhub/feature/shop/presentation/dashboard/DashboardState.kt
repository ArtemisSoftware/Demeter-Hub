package com.artemissoftware.demeterhub.feature.shop.presentation.dashboard

import com.artemissoftware.demeterhub.core.presentation.models.ErrorInfo
import com.artemissoftware.demeterhub.feature.shop.domain.models.Category
import com.artemissoftware.demeterhub.feature.shop.domain.models.Shop

data class DashboardState(
    val isLoading: Boolean = false,
    val categories: List<Category> = emptyList(),
    val shops: List<Shop> = emptyList(),
    val errorInfo: ErrorInfo? = null
)