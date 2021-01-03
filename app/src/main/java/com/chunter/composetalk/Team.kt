package com.chunter.composetalk

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Team(
    @SerialName("idTeam")
    val id: Int,
    @SerialName("strTeam")
    val name: String,
    @SerialName("strDescriptionEN")
    val description: String,
    @SerialName("strAlternate")
    val alternateName: String,
    @SerialName("intFormedYear")
    val formationYear: Int,
    @SerialName("strTeamBadge")
    val badgeUrl: String,
    @SerialName("strWebsite")
    val websiteUrl: String,
    @SerialName("strFacebook")
    val facebookUrl: String,
    @SerialName("strTwitter")
    val twitterUrl: String,
    @SerialName("strInstagram")
    val instagramUrl: String
) : Parcelable