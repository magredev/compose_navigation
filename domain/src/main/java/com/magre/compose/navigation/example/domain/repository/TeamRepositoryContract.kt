package com.magre.compose.navigation.example.domain.repository

import com.magre.compose.navigation.example.domain.model.TeamDomain
import io.reactivex.Single

interface TeamRepositoryContract {

    fun getTeams(): Single<List<TeamDomain>>
}
