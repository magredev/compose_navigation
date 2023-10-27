package com.magre.compose.navigation.example.ui.screens.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.magre.compose.navigation.example.R

@Composable
fun SettingsScreen() {
    SettingsBody()
}

@Composable
fun SettingsBody() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.settings_content),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun SettingsPreview() {
    SettingsScreen()
}
