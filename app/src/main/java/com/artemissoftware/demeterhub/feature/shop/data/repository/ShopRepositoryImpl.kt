package com.artemissoftware.demeterhub.feature.shop.data.repository

import com.artemissoftware.demeterhub.core.data.remote.HandleNetwork
import com.artemissoftware.demeterhub.core.data.remote.source.DemeterHubApiSource
import com.artemissoftware.demeterhub.core.domain.Resource
import com.artemissoftware.demeterhub.feature.shop.data.mapper.toCategory
import com.artemissoftware.demeterhub.feature.shop.data.mapper.toShop
import com.artemissoftware.demeterhub.feature.shop.domain.models.Category
import com.artemissoftware.demeterhub.feature.shop.domain.models.Dashboard
import com.artemissoftware.demeterhub.feature.shop.domain.models.Shop
import com.artemissoftware.demeterhub.feature.shop.domain.repository.ShopRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val demeterHubApiSource: DemeterHubApiSource
): ShopRepository {

    override suspend fun getDashboard(latitude: Double, longitude: Double): Resource<Dashboard> {
        return coroutineScope {
            val deferredCategories = async { getCategories() }
            val deferredShops = async { getShops(latitude = latitude, longitude = longitude) }

            // Await the results of both async tasks
            val resultCategories = deferredCategories.await()
            val resultShops = deferredShops.await()

            when{
                resultCategories is Resource.Success && resultShops is Resource.Success ->{
                    Resource.Success(Dashboard(categories = resultCategories.data, shops = resultShops.data))
                }
                resultCategories is Resource.Failure -> {
                    Resource.Failure(resultCategories.error)
                }
                else -> Resource.Failure((resultShops as Resource.Failure).error)
            }
        }
    }

    private suspend fun getCategories(): Resource<List<Category>> {
        return HandleNetwork.safeNetworkCall {
            demeterHubApiSource.getCategories().map { it.toCategory() }
        }
    }

    private suspend fun getShops(latitude: Double, longitude: Double): Resource<List<Shop>> {
        return HandleNetwork.safeNetworkCall {
            demeterHubApiSource.getRestaurants(latitude = latitude, longitude = longitude).map { it.toShop() }
        }
    }
}