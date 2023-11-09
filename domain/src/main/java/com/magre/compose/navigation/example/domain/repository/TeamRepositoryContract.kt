package com.magre.compose.navigation.example.domain.repository

import com.magre.compose.navigation.example.domain.model.TeamDomain
import kotlinx.coroutines.flow.Flow

interface TeamRepositoryContract {

    fun getTeams(): Flow<List<TeamDomain>>
}
