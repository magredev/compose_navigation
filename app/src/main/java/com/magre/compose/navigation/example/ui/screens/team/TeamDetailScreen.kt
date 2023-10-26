@file:OptIn(ExperimentalMaterial3Api::class)

package com.magre.compose.navigation.example.ui.screens.team

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun TeamDetailScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Bike detail") },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back",
                    modifier = Modifier.clickable { navController.popBackStack() }
                )
            }
        )
    }) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            TeamDetailBody()
        }
    }
}

@Composable
fun TeamDetailBody() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text("Bike detail")
        Button(onClick = {

        }) {
            Text("Go back")
        }
    }

}

@Preview
@Composable
fun TeamDetailPreview() {
    val navController = rememberNavController()
    TeamDetailScreen(navController = navController)
}
