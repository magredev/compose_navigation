package com.magre.compose.navigation.example.data.mapper

import com.magre.compose.navigation.example.data.model.TeamData
import com.magre.compose.navigation.example.data.webservice.dto.TeamDto
import javax.inject.Inject

class TeamDtoMapper @Inject constructor() : Mapper<TeamDto, TeamData>() {

    override fun map(unmapped: TeamDto): TeamData {
        return TeamData(
            id = unmapped.id,
            abbreviation = unmapped.abbreviation ?: "",
            city = unmapped.city ?: "",
            conference = unmapped.conference ?: "",
            division = unmapped.division ?: "",
            fullName = unmapped.fullName ?: "",
            name = unmapped.name ?: ""
        )
    }
}
