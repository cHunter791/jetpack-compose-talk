package com.chunter.composetalk.ui.screens.detail

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.chunter.composetalk.R
import com.chunter.composetalk.data.Team
import com.chunter.composetalk.teamPreview
import com.chunter.composetalk.ui.components.SocialMediaButton
import com.chunter.composetalk.ui.components.TeamRow
import com.chunter.composetalk.ui.screens.detail.DetailViewModel.ViewState

@Composable
fun DetailScreen(
    teamId: Int,
    viewModel: DetailViewModel = viewModel()
) {
    val state: ViewState by viewModel.state.observeAsState(initial = ViewState())
    val team = state.team

    if (team == null) {
        viewModel.getTeam(teamId)
        LoadingView()
    } else {
        TeamDetailView(team = team)
    }
}

@Composable
fun LoadingView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingViewPreview() {
    LoadingView()
}

@Composable
fun TeamDetailView(team: Team) {
    ScrollableColumn {
        TeamRow(
            team = team,
            modifier = Modifier.size(128.dp)
        )
        Text(
            text = team.description,
            modifier = Modifier.padding(16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialMediaButton(team.websiteUrl, R.drawable.ic_website)
            SocialMediaButton(team.facebookUrl, R.drawable.ic_facebook)
            SocialMediaButton(team.twitterUrl, R.drawable.ic_twitter)
            SocialMediaButton(team.instagramUrl, R.drawable.ic_instagram)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamDetailViewPreview() {
    TeamDetailView(
        team = teamPreview
    )
}