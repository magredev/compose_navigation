package com.magre.compose.navigation.example.data.webservice

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        try {
            return chain.proceed(
                request
                    .newBuilder()
                    .addHeader("X-RapidAPI-Key", API_KEY)
                    .addHeader("X-RapidAPI-Host", API_HOST)
                    .url(request.url)
                    .build()
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return chain.proceed(request)
    }

    companion object {
        private const val API_KEY = "0840a3e68emsh5e7bdf86835a5d8p1b766ejsnbd804594fdcd"
        private const val API_HOST = "free-nba.p.rapidapi.com"
    }
}
