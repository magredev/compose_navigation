package com.magre.compose.navigation.example.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.magre.compose.navigation.example.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun FirstScreen(navController: NavController) {
    Scaffold {
        FirstScreenBodyContent(navController)
    }
}

@Composable
fun FirstScreenBodyContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("First Screen")
        Button(onClick = {
            navController.navigate(route = AppScreens.SecondScreen.route + "/Hello param1")
        }) {
            Text("Go")
        }
    }
}
