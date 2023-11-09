package com.magre.compose.navigation.example.di.module

import android.content.Context
import com.magre.compose.navigation.example.data.webservice.AuthInterceptor
import com.magre.compose.navigation.example.data.webservice.NbaWebservice
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
open class AppModule {

    @Provides
    @Singleton
    open fun provideNbaWebservice(
        @ApplicationContext context: Context,
        @Named authInterceptor: AuthInterceptor
    ): NbaWebservice {
        return NbaWebservice.create(context, authInterceptor)
    }

    @Provides
    @Singleton
    @Named
    open fun provideAuthInterceptor(): AuthInterceptor {
        return AuthInterceptor()
    }
}
