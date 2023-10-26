package com.magre.compose.navigation.example.di.module

import com.magre.compose.navigation.example.data.repository.TeamRepository
import com.magre.compose.navigation.example.domain.repository.TeamRepositoryContract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DomainModule {

    @Binds
    abstract fun provideTeamRepository(repository: TeamRepository): TeamRepositoryContract
}
