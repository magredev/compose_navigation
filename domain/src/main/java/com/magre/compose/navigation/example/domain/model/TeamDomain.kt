package com.magre.compose.navigation.example.domain.model

data class TeamDomain(
    val id: Int,
    val abbreviation: String,
    val city: String,
    val conference: String,
    val division: String,
    val fullName: String,
    val name: String
)
