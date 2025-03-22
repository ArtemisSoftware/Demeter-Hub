package com.artemissoftware.demeterhub.core.data.di

import com.artemissoftware.demeterhub.core.data.remote.source.DemeterHubApiSource
import com.artemissoftware.demeterhub.core.data.repository.AuthenticationRepositoryImpl
import com.artemissoftware.demeterhub.feature.authentication.domain.repository.AuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthenticationRepository(demeterHubApiSource: DemeterHubApiSource): AuthenticationRepository {
        return AuthenticationRepositoryImpl(demeterHubApiSource = demeterHubApiSource)
    }
}