package com.artemissoftware.demeterhub.core.data.di

import android.content.Context
import com.artemissoftware.demeterhub.core.data.datastore.source.SessionDataStore
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

object DataStoreModule {
    @Provides
    @Singleton
    fun provideSessionDataStore(@ApplicationContext context: Context): SessionDataStore {
        return SessionDataStore(context)
    }
}