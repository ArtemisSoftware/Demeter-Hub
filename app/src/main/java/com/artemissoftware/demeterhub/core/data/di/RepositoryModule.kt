package com.artemissoftware.demeterhub.core.data.di

import com.artemissoftware.demeterhub.core.data.datastore.source.SessionDataStore
import com.artemissoftware.demeterhub.core.data.remote.source.DemeterHubApiSource
import com.artemissoftware.demeterhub.core.data.repository.AuthenticationRepositoryImpl
import com.artemissoftware.demeterhub.core.domain.repository.AuthenticationRepository
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
    fun provideAuthenticationRepository(demeterHubApiSource: DemeterHubApiSource, sessionDataStore: SessionDataStore): AuthenticationRepository {
        return AuthenticationRepositoryImpl(demeterHubApiSource = demeterHubApiSource, sessionDataStore = sessionDataStore)
    }
}