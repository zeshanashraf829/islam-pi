package com.nasash.islampi.data.network.rest

import android.content.Context
import com.nasash.islampi.util.AppUtil
import com.nasash.islampi.util.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(
    context: Context
) : Interceptor {

    private val applicationContext = context.applicationContext

    @Throws(NoInternetException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!AppUtil.isInternetAvailable(applicationContext)) throw NoInternetException(com.nasash.islampi.constants.AppConstant.INTERNET_ERROR)
        return chain.proceed(chain.request())
    }


}