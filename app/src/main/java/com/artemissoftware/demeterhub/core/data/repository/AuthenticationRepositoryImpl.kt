package com.artemissoftware.demeterhub.core.data.repository

import com.artemissoftware.demeterhub.core.data.datastore.source.SessionDataStore
import com.artemissoftware.demeterhub.core.data.mapper.toAuthentication
import com.artemissoftware.demeterhub.core.data.remote.HandleNetwork
import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.LogInRequest
import com.artemissoftware.demeterhub.core.data.remote.dto.authentication.SignUpRequest
import com.artemissoftware.demeterhub.core.data.remote.source.DemeterHubApiSource
import com.artemissoftware.demeterhub.core.domain.Resource
import com.artemissoftware.demeterhub.core.domain.error.DataError
import com.artemissoftware.demeterhub.feature.authentication.domain.models.Authentication
import com.artemissoftware.demeterhub.feature.authentication.domain.repository.AuthenticationRepository

class AuthenticationRepositoryImpl(
    private val demeterHubApiSource: DemeterHubApiSource,
    private val sessionDataStore: SessionDataStore
): AuthenticationRepository {

    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Resource<Authentication> {
        return Resource.Success(Authentication(""))
//        return HandleNetwork.safeNetworkCall {
//            demeterHubApiSource.signUp(request = SignUpRequest(name = name, email = email, password = password))
//                .toAuthentication()
//                .also {
//                    sessionDataStore.setToken(token = it.token)
//                }
//        }
    }

    override suspend fun login(email: String, password: String): Resource<Authentication> {
        return Resource.Success(Authentication(""))
//        return HandleNetwork.safeNetworkCall {
//            demeterHubApiSource.login(request = LogInRequest(email = email, password = password))
//                .toAuthentication()
//                .also {
//                    sessionDataStore.setToken(token = it.token)
//                }
//        }
    }
}