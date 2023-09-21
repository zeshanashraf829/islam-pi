package com.getgoally.learnerapp.di

import com.nasash.islampi.data.network.rest.api.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideAuthenticationApi(retrofit: Retrofit.Builder): AuthenticationApi {
        return retrofit.build().create(AuthenticationApi::class.java)
    }

}