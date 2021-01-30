package com.chunter.composetalk.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chunter.composetalk.data.Team
import com.chunter.composetalk.teamPreview
import com.chunter.composetalk.ui.resources.ComposeTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun TeamRow(
    team: Team,
    modifier: Modifier = Modifier,
    onItemSelected: ((Team) -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .clickable(
                enabled = onItemSelected != null,
                onClick = { onItemSelected?.invoke(team) }
            )
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoilImage(
            data = team.badgeUrl,
            contentDescription = "Team Badge",
            modifier = modifier
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(team.name)
            Text(team.alternateName)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamRowPreview() {
    ComposeTheme {
        TeamRow(team = teamPreview)
    }
}