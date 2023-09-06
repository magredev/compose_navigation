package com.magre.compose.navigation.example.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.magre.compose.navigation.example.screens.FirstScreen
import com.magre.compose.navigation.example.screens.SecondScreen

@ExperimentalMaterial3Api
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route) {
        composable(route = AppScreens.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(
            route = AppScreens.SecondScreen.route + "/{param1}",
            arguments = listOf(navArgument(name = "param1") {
                type = NavType.StringType
            })
        ) {
            SecondScreen(navController = navController, it.arguments?.getString("param1"))
        }
    }
}
