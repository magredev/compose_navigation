package com.magre.compose.navigation.example.domain.usecase.base

import com.magre.compose.navigation.example.domain.executor.SchedulersFacade
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.Disposable

abstract class UseCase<TYPE, PARAMS> internal constructor(
    val schedulersFacade: SchedulersFacade
) {

    protected var disposable: Disposable? = null

    protected abstract fun build(params: PARAMS): TYPE

    protected fun getObserveScheduler(observeOn: ObserveOn): Scheduler {
        return when (observeOn) {
            ObserveOn.UI -> schedulersFacade.ui()
            ObserveOn.BACKGROUND -> schedulersFacade.io()
        }
    }

    fun dispose() {
        disposable?.dispose()
    }

    enum class ObserveOn {
        UI, BACKGROUND
    }

    abstract class RxSingleUseCase<TYPE : Any, PARAMS>(schedulersFacade: SchedulersFacade) :
        UseCase<Single<TYPE>, PARAMS>(schedulersFacade) {

        @JvmOverloads
        fun execute(
            success: ((TYPE) -> Unit),
            error: ((Throwable) -> Unit) = {},
            params: PARAMS,
            observeOn: ObserveOn = ObserveOn.UI
        ) {
            dispose()
            disposable =
                build(params)
                    .subscribeOn(schedulersFacade.io())
                    .observeOn(getObserveScheduler(observeOn))
                    .subscribe(success, error)
        }
    }
}
