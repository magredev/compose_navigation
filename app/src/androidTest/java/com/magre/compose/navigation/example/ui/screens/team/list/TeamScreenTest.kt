package com.magre.compose.navigation.example.ui.screens.team.list

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.magre.compose.navigation.example.model.TeamModel
import com.magre.compose.navigation.example.ui.MainActivity
import com.magre.compose.navigation.example.ui.theme.ComposeNavigationTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TeamScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun team_row_composable_test() {
        composeTestRule.activity.setContent {
            ComposeNavigationTheme {
                Surface(
                    Modifier.fillMaxSize()
                ) {
                    TeamRow(team = teamModel, onTeamClick = {})
                }
            }
        }
        composeTestRule.onNodeWithTag("TEAM_ROW_TAG").assertIsDisplayed()
        composeTestRule.onNodeWithTag(
            testTag = "TEAM_ROW_TEAM_NAME_TAG",
            useUnmergedTree = true
        ).assertTextEquals(teamModel.fullName)
        composeTestRule.onNodeWithTag(
            testTag = "TEAM_ROW_TEAM_CITY_TAG",
            useUnmergedTree = true
        ).assertTextEquals(teamModel.city)
    }

    companion object {

        private val teamModel = TeamModel(
            id = 1,
            abbreviation = "abbreviation",
            city = "city",
            conference = "conference",
            division = "division",
            fullName = "fullName",
            name = "name"
        )
    }
}
