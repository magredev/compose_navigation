@file:OptIn(ExperimentalMaterial3Api::class)

package com.magre.compose.navigation.example.ui.screens.team.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.magre.compose.navigation.example.R
import com.magre.compose.navigation.example.ui.common.AppTopAppBar

@Composable
fun TeamDetailScreen(
    navController: NavHostController,
    teamId: Int?
) {
    Scaffold(topBar = {
        AppTopAppBar(
            title = stringResource(id = R.string.team_detail_title),
            onBackClick = { navController.popBackStack() }
        )
    }) { padding ->
        TeamDetailBody(padding = padding)
    }
}

@Composable
fun TeamDetailBody(padding: PaddingValues) {
    Box(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.team_detail_content),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun TeamDetailPreview() {
    val navController = rememberNavController()
    TeamDetailScreen(navController = navController, teamId = 1)
}
