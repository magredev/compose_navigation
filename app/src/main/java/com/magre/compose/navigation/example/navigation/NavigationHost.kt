package com.magre.compose.navigation.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.magre.compose.navigation.example.ui.screens.home.HomeScreen
import com.magre.compose.navigation.example.ui.screens.settings.SettingsScreen
import com.magre.compose.navigation.example.ui.screens.team.detail.TeamDetailScreen
import com.magre.compose.navigation.example.ui.screens.team.list.TeamScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavMenuItem.Home.route,
    ) {
        composable(BottomNavMenuItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavMenuItem.Team.route) {
            TeamScreen(navController = navController)
        }
        composable(BottomNavMenuItem.Settings.route) {
            SettingsScreen()
        }
        composable(
            route = AppScreens.TeamDetailScreen.route + "/{teamId}",
            arguments = listOf(navArgument(name = "teamId") {
                type = NavType.IntType
            })
        ) {
            TeamDetailScreen(navController = navController, teamId = it.arguments?.getInt("teamId"))
        }
    }
}
