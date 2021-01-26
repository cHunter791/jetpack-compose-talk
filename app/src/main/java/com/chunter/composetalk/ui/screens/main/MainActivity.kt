package com.chunter.composetalk.ui.screens.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.viewinterop.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.chunter.composetalk.ui.resources.ComposeTheme
import com.chunter.composetalk.ui.screens.detail.DetailScreen
import com.chunter.composetalk.ui.screens.teamlist.TeamListScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "teamlist") {
        composable("teamlist") { TeamListScreen(viewModel, navController) }
        composable(
            "detail/{teamId}",
            arguments = listOf(navArgument("teamId") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("teamId")
                ?.let { teamId -> DetailScreen(teamId) }
        }
    }
}