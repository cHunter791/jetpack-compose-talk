package com.chunter.composetalk

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamResponse(
    @SerialName("teams")
    val teams: List<Team>
)