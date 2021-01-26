package com.chunter.composetalk.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamResponse(
    @SerialName("teams")
    val teams: List<Team>
)