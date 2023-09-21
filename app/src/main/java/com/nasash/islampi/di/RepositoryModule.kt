package com.getgoally.learnerapp.di

import com.nasash.islampi.data.db.*
import com.nasash.islampi.data.db.dao.*
import com.nasash.islampi.data.network.rest.api.AuthenticationApi
import com.nasash.islampi.data.repo.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthenticationRepo(
        authenticationApi: AuthenticationApi, authenticationDao: AuthenticationDao
    ): AuthenticationRepo {
        return AuthenticationRepo(
            authenticationApi,
            authenticationDao
        )
    }

}
