package com.magre.compose.navigation.example.data.repository

import com.magre.compose.navigation.example.data.mapper.TeamDataMapper
import com.magre.compose.navigation.example.data.model.TeamData
import com.magre.compose.navigation.example.data.source.TeamDataSource
import com.magre.compose.navigation.example.domain.model.TeamDomain
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TeamRepositoryTest {

    private lateinit var teamRepository: TeamRepository

    private val teamDataSource: TeamDataSource = mockk()
    private val teamDataMapper: TeamDataMapper = mockk()

    @Before
    fun setUp() {
        teamRepository = TeamRepository(
            teamDataSource,
            teamDataMapper
        )
    }

    @Test
    fun `When getTeams is invoked, Then returns the teams list from the data source properly mapped`() {
        every { teamDataSource.getTeams() } returns Single.just(teamsData)
        every { teamDataMapper.map(teamsData) } returns teamsDomain

        val result = teamRepository.getTeams().test()
        result.assertNoErrors()
        result.assertComplete()

        verify(exactly = 1) { teamDataSource.getTeams() }
        verify(exactly = 1) { teamDataMapper.map(teamsData) }

        assertEquals(result.values().first(), teamsDomain)
    }

    @Test
    fun `When getTeams is invoked, And the data source returns an error, Then returns the same error`() {
        val throwable = Throwable("Data source error")

        every { teamDataSource.getTeams() } returns Single.error(throwable)

        val result = teamRepository.getTeams().test()
        result.assertError(throwable)

        verify(exactly = 1) { teamDataSource.getTeams() }
        verify(exactly = 0) { teamDataMapper.map(teamsData) }

        assertEquals(result.errors().first(), throwable)
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
        private val teamDomain1 = TeamDomain(
            id = 1,
            abbreviation = "abbreviation team 1",
            city = "city team 1",
            conference = "conference team 1",
            division = "division team 1",
            fullName = "full name team 1",
            name = "name team 1"
        )
        private val teamDomain2 = TeamDomain(
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
        private val teamsDomain = listOf(
            teamDomain1,
            teamDomain2
        )
    }
}
