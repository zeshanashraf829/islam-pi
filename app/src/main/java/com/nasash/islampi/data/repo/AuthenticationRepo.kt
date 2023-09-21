package com.nasash.islampi.data.repo

import com.nasash.islampi.data.db.dao.AuthenticationDao
import com.nasash.islampi.data.model.api.token.Authentication
import com.nasash.islampi.data.network.rest.api.AuthenticationApi


class AuthenticationRepo(
    private val authenticationApi: AuthenticationApi,
    private val authenticationDao: AuthenticationDao,
) {

    suspend fun hitAuthTokenApi() = authenticationApi.hitAuthTokenApi()

    suspend fun add(authentication: Authentication) =
        authenticationDao.add(authentication)

    suspend fun getAuthentication() = authenticationDao.getAuthentication()

    suspend fun deleteAll() = authenticationDao.deleteAll()
}