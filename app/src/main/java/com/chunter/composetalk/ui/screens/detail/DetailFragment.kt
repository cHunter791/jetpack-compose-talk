package com.chunter.composetalk.ui.screens.detail

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.chunter.composetalk.R
import com.chunter.composetalk.data.Team
import com.chunter.composetalk.ui.components.SocialMediaButton
import com.chunter.composetalk.ui.components.TeamRow

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var loadingBar: ProgressBar
    private lateinit var detailGroup: Group
    private lateinit var teamRowView: TeamRow
    private lateinit var descriptionText: TextView
    private lateinit var websiteFab: SocialMediaButton
    private lateinit var facebookFab: SocialMediaButton
    private lateinit var twitterFab: SocialMediaButton
    private lateinit var instagramFab: SocialMediaButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)

        viewModel.state.observe(viewLifecycleOwner) { state ->
            loadingBar.isVisible = state.team == null
            detailGroup.isVisible = state.team != null

            if (state.team != null) {
                setupUI(state.team)
            }
        }

        viewModel.getTeam(requireArguments().getInt("teamId"))
    }

    private fun initViews(view: View) {
        loadingBar = view.findViewById(R.id.loading_bar)
        detailGroup = view.findViewById(R.id.detail_group)
        teamRowView = view.findViewById(R.id.team_row_view)
        descriptionText = view.findViewById(R.id.description)
        websiteFab = view.findViewById(R.id.website_fab)
        facebookFab = view.findViewById(R.id.facebook_fab)
        twitterFab = view.findViewById(R.id.twitter_fab)
        instagramFab = view.findViewById(R.id.instagram_fab)
    }

    private fun setupUI(team: Team) {
        teamRowView.setData(team)

        descriptionText.text = team.description
        descriptionText.movementMethod = ScrollingMovementMethod()

        websiteFab.isVisible = team.websiteUrl.isNotEmpty()
        websiteFab.setUrl(team.websiteUrl)

        facebookFab.isVisible = team.facebookUrl.isNotEmpty()
        facebookFab.setUrl(team.websiteUrl)

        twitterFab.isVisible = team.twitterUrl.isNotEmpty()
        twitterFab.setUrl(team.websiteUrl)

        instagramFab.isVisible = team.instagramUrl.isNotEmpty()
        instagramFab.setUrl(team.websiteUrl)
    }
}