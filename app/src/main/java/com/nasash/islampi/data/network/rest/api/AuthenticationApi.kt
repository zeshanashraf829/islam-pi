package com.nasash.islampi.data.network.rest.api

import com.nasash.islampi.constants.WebServiceConstant
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface AuthenticationApi {

    @GET(value = WebServiceConstant.AUTHENTICATION_TOKEN_URL)
    suspend fun hitAuthTokenApi(
        @Header(com.nasash.islampi.data.network.rest.Headers.Authorization) authorization: String = WebServiceConstant.authorization,
        @Header(
            com.nasash.islampi.data.network.rest.Headers.Content_Type
        ) contentType: String = WebServiceConstant.contentType
    ): NetworkResponse<com.nasash.islampi.data.model.api.token.Authentication, com.nasash.islampi.data.model.api.ErrorResponse>
}

