package com.magre.compose.navigation.example.data.webservice

import android.content.Context
import com.magre.compose.navigation.example.data.webservice.dto.GetTeamsDto
import io.reactivex.Single
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.File
import java.util.concurrent.TimeUnit

interface NbaWebservice {

    @GET(TEAMS_ENDPOINT)
    fun getTeams(): Single<GetTeamsDto>

    companion object {
        private const val NBA_API_BASE_URL = "https://free-nba.p.rapidapi.com"

        const val TEAMS_ENDPOINT = "teams"

        private const val CACHE_SIZE = (10 * 1024 * 1024).toLong()
        private const val TIMEOUT = 60L

        fun create(
            context: Context,
            authInterceptor: AuthInterceptor
        ): NbaWebservice {
            val cacheFile = File(context.cacheDir, "http-cache-nba")
            val cache = Cache(cacheFile, CACHE_SIZE)

            val builder = OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(authInterceptor)
                .cache(cache)

            val okHttpClient = builder.build()

            return Retrofit.Builder()
                .baseUrl(NBA_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(NbaWebservice::class.java)
        }
    }
}
