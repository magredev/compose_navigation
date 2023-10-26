package com.magre.compose.navigation.example.navigation

sealed class AppScreens(val route: String) {
    object TeamDetailScreen : AppScreens("team_detail_screen")
}
