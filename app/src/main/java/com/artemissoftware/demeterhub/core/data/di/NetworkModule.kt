package com.artemissoftware.demeterhub.core.data.di

import com.artemissoftware.demeterhub.core.data.remote.api.DemeterHubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(DemeterHubApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDemeterHubApi(retrofit: Retrofit): DemeterHubApi {
        return retrofit
            .create(DemeterHubApi::class.java)
    }
}