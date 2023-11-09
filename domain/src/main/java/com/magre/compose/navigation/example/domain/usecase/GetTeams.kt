package com.magre.compose.navigation.example.domain.usecase

import com.magre.compose.navigation.example.domain.model.TeamDomain
import com.magre.compose.navigation.example.domain.repository.TeamRepositoryContract
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTeams @Inject constructor(
    private val teamRepository: TeamRepositoryContract
) {

    operator fun invoke(): Flow<List<TeamDomain>> {
        return teamRepository.getTeams()
    }
}
