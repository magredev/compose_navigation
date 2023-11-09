package com.magre.compose.navigation.example.data.repository

import com.magre.compose.navigation.example.data.mapper.TeamDataMapper
import com.magre.compose.navigation.example.data.source.TeamDataSource
import com.magre.compose.navigation.example.domain.model.TeamDomain
import com.magre.compose.navigation.example.domain.repository.TeamRepositoryContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamRepository @Inject constructor(
    private val teamDataSource: TeamDataSource,
    private val teamDataMapper: TeamDataMapper
) : TeamRepositoryContract {

    override fun getTeams(): Flow<List<TeamDomain>> {
        return flow {
            emit(getTeamsFromRemote())
        }
    }

    private suspend fun getTeamsFromRemote(): List<TeamDomain> {
        return teamDataSource.getTeams()
            .map {
                teamDataMapper.map(it)
            }
    }
}
