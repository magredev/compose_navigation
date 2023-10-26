package com.magre.compose.navigation.example.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.magre.compose.navigation.example.R

sealed class BottomNavMenuItem(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    val route: String
) {
    object Home : BottomNavMenuItem(
        R.drawable.ic_home,
        R.string.menu_item_home,
        homeRoute
    )

    object Team : BottomNavMenuItem(
        R.drawable.ic_basketball_ball,
        R.string.menu_item_team,
        teamRoute
    )

    object Settings : BottomNavMenuItem(
        R.drawable.ic_settings,
        R.string.menu_item_settings,
        settingsRoute
    )

    companion object {
        private const val homeRoute = "home"
        private const val teamRoute = "team"
        private const val settingsRoute = "settings"
    }
}
