package com.magre.compose.navigation.example.ui.screens.team

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.magre.compose.navigation.example.R
import com.magre.compose.navigation.example.model.TeamModel
import com.magre.compose.navigation.example.navigation.AppScreens

@Composable
fun TeamScreen(viewModel: TeamViewModel = hiltViewModel(), navController: NavHostController) {

    val teamState by viewModel.teamState.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(teamState.teamData) { team ->
            TeamRow(team, navController)
        }
    }
}

@Composable
fun TeamRow(team: TeamModel, navController: NavHostController) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                Toast
                    .makeText(context, "${team.name} clicked", Toast.LENGTH_SHORT)
                    .show()
                navController.navigate(AppScreens.TeamDetailScreen.route)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_basketball_ball),
            contentDescription = "team image",
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(color = Color.Green)
                .padding(8.dp)
        )
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(text = team.fullName, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = team.city, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview
@Composable
fun TeamRowPreview() {
    val navController = rememberNavController()
    TeamRow(
        TeamModel(
            id = 1,
            abbreviation = "abbreviation",
            city = "city",
            conference = "conference",
            division = "division",
            fullName = "fullName",
            name = "name"
        ), navController
    )
}

@Preview(showSystemUi = true)
@Composable
fun TeamScreenPreview() {
    val navController = rememberNavController()
    TeamScreen(navController = navController)
}
