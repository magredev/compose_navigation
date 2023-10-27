@file:OptIn(ExperimentalMaterial3Api::class)

package com.magre.compose.navigation.example.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.magre.compose.navigation.example.R
import com.magre.compose.navigation.example.navigation.BottomNavMenuItem
import com.magre.compose.navigation.example.navigation.NavigationHost
import com.magre.compose.navigation.example.ui.theme.ComposeNavigationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    ComposeNavigationTheme {
        val navController: NavHostController = rememberNavController()

        Scaffold(
            bottomBar = {
                MainBottomBar(navController = navController)
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                NavigationHost(navController = navController)
            }
        }
    }
}

@Composable
fun MainBottomBar(
    navController: NavHostController
) {
    val screens = listOf(
        BottomNavMenuItem.Home,
        BottomNavMenuItem.Team,
        BottomNavMenuItem.Settings
    )

    NavigationBar(
        modifier = Modifier.clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
        containerColor = colorResource(id = R.color.nba_blue),
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->
            NavigationBarItem(
                label = {
                    Text(text = stringResource(id = screen.title))
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = ""
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.nba_white),
                    selectedTextColor = colorResource(id = R.color.nba_red),
                    indicatorColor = colorResource(id = R.color.nba_red),
                    unselectedIconColor = colorResource(id = R.color.nba_white),
                    unselectedTextColor = colorResource(id = R.color.nba_white)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
