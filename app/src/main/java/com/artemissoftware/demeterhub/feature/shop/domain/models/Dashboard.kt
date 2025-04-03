package com.artemissoftware.demeterhub.feature.shop.domain.models

data class Dashboard(
    val categories: List<Category>,
    val shops: List<Shop>
)
