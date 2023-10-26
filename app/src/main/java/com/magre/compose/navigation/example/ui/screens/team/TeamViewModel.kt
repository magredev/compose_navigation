package com.magre.compose.navigation.example.ui.screens.team

import androidx.lifecycle.ViewModel
import com.magre.compose.navigation.example.domain.usecase.GetTeams
import com.magre.compose.navigation.example.mapper.TeamMapper
import com.magre.compose.navigation.example.model.TeamModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getTeams: GetTeams,
    private val teamMapper: TeamMapper
) : ViewModel() {

    private val _teamState = MutableStateFlow(TeamState())
    val teamState: StateFlow<TeamState> = _teamState.asStateFlow()

    init {
        getTeams.execute(
            { teams ->
                onGetTeams(teamMapper.map(teams))
            },
            {
                onGetTeamsError()
            },
            GetTeams.Params()
        )
    }

    private fun onGetTeams(teams: List<TeamModel>) {
        _teamState.value = TeamState(teamData = teams)
    }

    private fun onGetTeamsError() {

    }
}

data class TeamState(
    val teamData: List<TeamModel> = emptyList()
)
