package com.magre.compose.navigation.example.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.magre.compose.navigation.example.navigation.AppNavigation
import com.magre.compose.navigation.example.ui.theme.ComposeNavigationTheme

@ExperimentalMaterial3Api
@Composable
fun NavigationExampleApp() {
    ComposeNavigationTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            AppNavigation()
        }
    }
}

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun NavigationExampleAppPreview() {
    NavigationExampleApp()
}
