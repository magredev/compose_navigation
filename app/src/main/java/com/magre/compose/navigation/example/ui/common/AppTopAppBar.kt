@file:OptIn(ExperimentalMaterial3Api::class)

package com.magre.compose.navigation.example.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.magre.compose.navigation.example.R

@Composable
fun AppTopAppBar(title: String, onBackClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back arrow"
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = colorResource(id = R.color.nba_blue),
            titleContentColor = colorResource(id = R.color.nba_white)
        )
    )
}
