package com.artemissoftware.demeterhub.core.data.di

import android.content.Context
import com.artemissoftware.demeterhub.core.data.datastore.source.SessionDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideSessionDataStore(@ApplicationContext context: Context): SessionDataStore {
        return SessionDataStore(context)
    }
}