package com.magre.compose.navigation.example.mapper

import com.magre.compose.navigation.example.data.mapper.Mapper
import com.magre.compose.navigation.example.domain.model.TeamDomain
import com.magre.compose.navigation.example.model.TeamModel
import javax.inject.Inject

class TeamMapper @Inject constructor() : Mapper<TeamDomain, TeamModel>() {

    override fun map(unmapped: TeamDomain): TeamModel {
        return TeamModel(
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
