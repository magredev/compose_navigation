package com.magre.compose.navigation.example.data.mapper

import com.magre.compose.navigation.example.data.model.TeamData
import com.magre.compose.navigation.example.domain.model.TeamDomain
import javax.inject.Inject

class TeamDataMapper @Inject constructor() : Mapper<TeamData, TeamDomain>() {

    override fun map(unmapped: TeamData): TeamDomain {
        return TeamDomain(
            id = unmapped.id,
            abbreviation = unmapped.abbreviation,
            city = unmapped.city,
            conference = unmapped.conference,
            division = unmapped.division,
            fullName = unmapped.fullName,
            name = unmapped.name
        )
    }
}
