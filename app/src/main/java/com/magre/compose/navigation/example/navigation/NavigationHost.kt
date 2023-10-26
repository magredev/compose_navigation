package com.magre.compose.navigation.example.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.magre.compose.navigation.example.ui.screens.settings.SettingsScreen
import com.magre.compose.navigation.example.ui.screens.home.HomeScreen
import com.magre.compose.navigation.example.ui.screens.home.HomeViewModel
import com.magre.compose.navigation.example.ui.screens.team.TeamDetailScreen
import com.magre.compose.navigation.example.ui.screens.team.TeamScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavMenuItem.Home.route,
    ) {
        composable(BottomNavMenuItem.Home.route) {
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(homeViewModel)
        }
        composable(BottomNavMenuItem.Team.route) {
            TeamScreen(navController = navController)
        }
        composable(BottomNavMenuItem.Settings.route) {
            SettingsScreen()
        }
        composable(AppScreens.TeamDetailScreen.route) {
            TeamDetailScreen(navController)
        }
    }
}
