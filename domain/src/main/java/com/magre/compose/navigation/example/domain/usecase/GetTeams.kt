package com.magre.compose.navigation.example.domain.usecase

import com.magre.compose.navigation.example.domain.executor.SchedulersFacade
import com.magre.compose.navigation.example.domain.model.TeamDomain
import com.magre.compose.navigation.example.domain.repository.TeamRepositoryContract
import com.magre.compose.navigation.example.domain.usecase.base.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetTeams @Inject constructor(
    schedulersFacade: SchedulersFacade,
    private val teamRepository: TeamRepositoryContract
) : UseCase.RxSingleUseCase<List<TeamDomain>, GetTeams.Params>(schedulersFacade) {

    override fun build(params: Params): Single<List<TeamDomain>> {
        return teamRepository.getTeams()
    }

    class Params
}
