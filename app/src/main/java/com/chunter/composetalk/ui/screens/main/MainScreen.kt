package com.chunter.composetalk.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.chunter.composetalk.ui.screens.detail.DetailScreen
import com.chunter.composetalk.ui.screens.teamlist.TeamListScreen

private const val argumentTeamId = "teamId"

const val routeTeamList = "teamList"
const val routeDetail = "detail"

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = routeTeamList) {
        composable(routeTeamList) { TeamListScreen(navController) }
        composable(
            "$routeDetail/{$argumentTeamId}",
            arguments = listOf(navArgument(argumentTeamId) { type = NavType.IntType })
        ) { backStackEntry ->
            val teamId = backStackEntry.arguments?.getInt(argumentTeamId)
                ?: throw IllegalStateException("DetailScreen requires $argumentTeamId")
            DetailScreen(teamId)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}