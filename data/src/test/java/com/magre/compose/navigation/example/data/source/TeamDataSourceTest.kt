package com.magre.compose.navigation.example.data.source

import com.magre.compose.navigation.example.data.mapper.TeamDtoMapper
import com.magre.compose.navigation.example.data.model.TeamData
import com.magre.compose.navigation.example.data.webservice.NbaWebservice
import com.magre.compose.navigation.example.data.webservice.dto.GetTeamsDto
import com.magre.compose.navigation.example.data.webservice.dto.TeamDto
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TeamDataSourceTest {

    private lateinit var teamDataSource: TeamDataSource

    private val nbaWebservice: NbaWebservice = mockk()
    private val teamDtoMapper: TeamDtoMapper = mockk()

    @Before
    fun setUp() {
        teamDataSource = TeamDataSource(
            nbaWebservice,
            teamDtoMapper
        )
    }

    @Test
    fun `When getTeams is called, Then returns a list of teams from the webservice properly mapped`() {
        every { nbaWebservice.getTeams() } returns Single.just(getTeamsDto)
        every { teamDtoMapper.map(getTeamsDto.teams) } returns teamsData

        val result = teamDataSource.getTeams().test()
        result.assertNoErrors()
        result.assertComplete()

        verify(exactly = 1) { nbaWebservice.getTeams() }
        verify(exactly = 1) { teamDtoMapper.map(getTeamsDto.teams) }

        assertEquals(result.values().first(), teamsData)
    }

    @Test
    fun `When getTeams is called, And the webservice returns an error, Then returns the same error`() {
        val error = Throwable("Error")
        every { nbaWebservice.getTeams() } returns Single.error(error)

        val result = teamDataSource.getTeams().test()
        result.assertError(error)

        verify(exactly = 1) { nbaWebservice.getTeams() }

        assertEquals(result.errors().first(), error)
    }

    companion object {

        private val teamData1 = TeamData(
            id = 1,
            abbreviation = "abbreviation team 1",
            city = "city team 1",
            conference = "conference team 1",
            division = "division team 1",
            fullName = "full name team 1",
            name = "name team 1"
        )
        private val teamData2 = TeamData(
            id = 2,
            abbreviation = "abbreviation team 2",
            city = "city team 2",
            conference = "conference team 2",
            division = "division team 2",
            fullName = "full name team 2",
            name = "name team 2"
        )
        private val teamDto1 = TeamDto(
            id = 1,
            abbreviation = "abbreviation team 1",
            city = "city team 1",
            conference = "conference team 1",
            division = "division team 1",
            fullName = "full name team 1",
            name = "name team 1"
        )
        private val teamDto2 = TeamDto(
            id = 1,
            abbreviation = "abbreviation team 2",
            city = "city team 2",
            conference = "conference team 2",
            division = "division team 2",
            fullName = "full name team 2",
            name = "name team 2"
        )
        private val teamsData = listOf(
            teamData1,
            teamData2
        )
        private val teamsDto = listOf(
            teamDto1,
            teamDto2
        )
        private val getTeamsDto = GetTeamsDto(teams = teamsDto)
    }
}
