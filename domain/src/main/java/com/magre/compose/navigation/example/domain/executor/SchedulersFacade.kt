package com.magre.compose.navigation.example.domain.executor

import io.reactivex.Scheduler

interface SchedulersFacade {

    /**
     * IO thread pool scheduler
     */
    fun io(): Scheduler

    /**
     * Main thread scheduler
     */
    fun ui(): Scheduler
}
