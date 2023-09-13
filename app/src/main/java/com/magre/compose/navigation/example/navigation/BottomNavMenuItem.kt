package com.magre.compose.navigation.example.navigation

import com.magre.compose.navigation.example.R

sealed class BottomNavMenuItem(
    val icon: Int,
    val title: String,
    val route: String
) {
    object Home : BottomNavMenuItem(
        R.drawable.ic_home,
        "Home",
        "home"
    )

    object Bike : BottomNavMenuItem(
        R.drawable.ic_bike,
        "Bike",
        "bike"
    )

    object Settings : BottomNavMenuItem(
        R.drawable.ic_settings,
        "Settings",
        "settings"
    )
}
