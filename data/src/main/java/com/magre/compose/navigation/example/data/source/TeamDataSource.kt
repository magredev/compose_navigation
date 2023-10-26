package com.magre.compose.navigation.example.data.source

import com.magre.compose.navigation.example.data.mapper.TeamDtoMapper
import com.magre.compose.navigation.example.data.model.TeamData
import com.magre.compose.navigation.example.data.webservice.NbaWebservice
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamDataSource @Inject constructor(
    private val nbaWebservice: NbaWebservice,
    private val teamDtoMapper: TeamDtoMapper
) {
    fun getTeams(): Single<List<TeamData>> {
        return nbaWebservice.getTeams()
            .map { teamsDto ->
                teamDtoMapper.map(teamsDto.teams)
            }
    }
}
