package com.magre.compose.navigation.example.ui.screens.team.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magre.compose.navigation.example.domain.usecase.GetTeams
import com.magre.compose.navigation.example.mapper.TeamMapper
import com.magre.compose.navigation.example.model.TeamModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getTeams: GetTeams,
    private val teamMapper: TeamMapper
) : ViewModel() {

    private val _viewState = MutableStateFlow(TeamViewState())
    val viewState: StateFlow<TeamViewState> = _viewState.asStateFlow()

    private val _viewEffects = MutableStateFlow<List<TeamViewEffect>>(emptyList())
    val viewEffect: StateFlow<List<TeamViewEffect>> = _viewEffects

    init {
        // todo: handle errors
        viewModelScope.launch {
            getTeams.invoke().onEach { teams ->
                onGetTeams(teamMapper.map(teams))
            }.launchIn(this)
        }
    }

    private fun onGetTeams(teams: List<TeamModel>) {
        _viewState.value = _viewState.value.copy(
            teamData = teams
        )
    }

    private fun onGetTeamsError() {
        _viewState.value = _viewState.value.copy(
            error = true
        )
    }

    fun onViewIntent(viewIntent: TeamViewIntent) {
        when (viewIntent) {
            is TeamViewIntent.OnTeamClick -> {
                addViewEffect(TeamViewEffect.NavigateToTeamDetail(viewIntent.teamId))
            }
        }
    }

    fun onEffectConsumed(effect: TeamViewEffect) {
        _viewEffects.value = _viewEffects.value - effect
    }

    private fun addViewEffect(viewEffect: TeamViewEffect) {
        _viewEffects.value = _viewEffects.value + viewEffect
    }
}

sealed class TeamViewEffect {
    data class NavigateToTeamDetail(val teamId: Int) : TeamViewEffect()
}

sealed class TeamViewIntent {
    data class OnTeamClick(val teamId: Int) : TeamViewIntent()
}

data class TeamViewState(
    val teamData: List<TeamModel> = emptyList(),
    val error: Boolean = false
)
