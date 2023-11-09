package com.magre.compose.navigation.example.domain.usecase

import com.magre.compose.navigation.example.domain.model.TeamDomain
import com.magre.compose.navigation.example.domain.repository.TeamRepositoryContract
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetTeamsTest {

    private lateinit var getTeams: GetTeams

    private val teamRepository: TeamRepositoryContract = mockk()

    @Before
    fun setUp() {
        getTeams = GetTeams(
            teamRepository
        )
    }

    @Test
    fun `When getTeams is invoked, Then returns a list of teams from the repository`() {
        val teamsDomainFlow = flow {
            emit(teamsDomain)
        }
        every { teamRepository.getTeams() } returns teamsDomainFlow

        runBlocking {
            val result = getTeams.invoke()
            verify(exactly = 1) { teamRepository.getTeams() }
            assertEquals(result.first(), teamsDomain)
        }
    }

    companion object {

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
            id = 2,
            abbreviation = "abbreviation team 2",
            city = "city team 2",
            conference = "conference team 2",
            division = "division team 2",
            fullName = "full name team 2",
            name = "name team 2"
        )
        private val teamsDomain = listOf(
            teamDomain1,
            teamDomain2
        )
    }
}
