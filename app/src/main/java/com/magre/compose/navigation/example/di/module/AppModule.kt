package com.magre.compose.navigation.example.di.module

import android.content.Context
import com.magre.compose.navigation.example.data.webservice.AuthInterceptor
import com.magre.compose.navigation.example.data.webservice.NbaWebservice
import com.magre.compose.navigation.example.domain.executor.SchedulersFacade
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
open class AppModule {

    @Provides
    open fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    open fun provideDomainSchedulersFacade(): SchedulersFacade {
        return object : SchedulersFacade {
            override fun io(): Scheduler {
                return Schedulers.io()
            }

            override fun ui(): Scheduler {
                return AndroidSchedulers.mainThread()
            }
        }
    }

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
