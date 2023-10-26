package com.magre.compose.navigation.example.data.webservice.dto

import com.google.gson.annotations.SerializedName

data class GetTeamsDto(
    @SerializedName("data") val teams: List<TeamDto>
)
