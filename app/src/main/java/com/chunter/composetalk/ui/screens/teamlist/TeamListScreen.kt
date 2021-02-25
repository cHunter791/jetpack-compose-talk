package com.chunter.composetalk.ui.screens.teamlist

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.chunter.composetalk.data.Team
import com.chunter.composetalk.teamPreview
import com.chunter.composetalk.ui.components.TeamRow
import com.chunter.composetalk.ui.screens.main.routeDetail
import com.chunter.composetalk.ui.screens.teamlist.TeamListViewModel.ViewState

@Composable
fun TeamListScreen(
    navController: NavHostController,
    viewModel: TeamListViewModel = viewModel()
) {
    val state: ViewState by viewModel.state.observeAsState(initial = ViewState())

    TeamListView(
        teams = state.teams,
        onItemSelected = { team ->
            navController.navigate("$routeDetail/${team.id}")
        }
    )
}

@Composable
fun TeamListView(
    teams: List<Team>,
    onItemSelected: (Team) -> Unit
) {
    LazyColumn {
        items(teams) { data ->
            TeamRow(
                team = data,
                modifier = Modifier.size(48.dp),
                onItemSelected = onItemSelected
            )
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun TeamListViewPreview() {
    TeamListView(
        teams = MutableList(10) { teamPreview },
        onItemSelected = { }
    )
}