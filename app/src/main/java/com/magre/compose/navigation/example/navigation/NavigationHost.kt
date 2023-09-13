package com.magre.compose.navigation.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.magre.compose.navigation.example.screens.BikeScreen
import com.magre.compose.navigation.example.screens.HomeScreen
import com.magre.compose.navigation.example.screens.SettingsScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavMenuItem.Home.route,
    ) {
        composable(BottomNavMenuItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavMenuItem.Bike.route) {
            BikeScreen()
        }
        composable(BottomNavMenuItem.Settings.route) {
            SettingsScreen()
        }
    }
}
