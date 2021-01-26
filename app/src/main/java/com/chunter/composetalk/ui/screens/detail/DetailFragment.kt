package com.chunter.composetalk.ui.screens.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.chunter.composetalk.R
import com.chunter.composetalk.data.Team
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var loadingBar: ProgressBar
    private lateinit var detailGroup: Group
    private lateinit var badgeImage: ImageView
    private lateinit var titleText: TextView
    private lateinit var alternateTitleText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var websiteFab: FloatingActionButton
    private lateinit var facebookFab: FloatingActionButton
    private lateinit var twitterFab: FloatingActionButton
    private lateinit var instagramFab: FloatingActionButton

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
        badgeImage = view.findViewById(R.id.badge)
        titleText = view.findViewById(R.id.title)
        alternateTitleText = view.findViewById(R.id.alternate_title)
        descriptionText = view.findViewById(R.id.description)
        websiteFab = view.findViewById(R.id.website_fab)
        facebookFab = view.findViewById(R.id.facebook_fab)
        twitterFab = view.findViewById(R.id.twitter_fab)
        instagramFab = view.findViewById(R.id.instagram_fab)
    }

    private fun setupUI(team: Team) {
        badgeImage.load(team.badgeUrl)
        titleText.text = team.name
        alternateTitleText.text = team.alternateName

        descriptionText.text = team.description
        descriptionText.movementMethod = ScrollingMovementMethod()

        websiteFab.isVisible = team.websiteUrl.isNotEmpty()
        if (websiteFab.isVisible) {
            websiteFab.setOnClickListener { openUrl(team.websiteUrl) }
        }

        facebookFab.isVisible = team.facebookUrl.isNotEmpty()
        if (facebookFab.isVisible) {
            facebookFab.setOnClickListener { openUrl(team.facebookUrl) }
        }

        twitterFab.isVisible = team.twitterUrl.isNotEmpty()
        if (twitterFab.isVisible) {
            twitterFab.setOnClickListener { openUrl(team.twitterUrl) }
        }

        instagramFab.isVisible = team.instagramUrl.isNotEmpty()
        if (instagramFab.isVisible) {
            instagramFab.setOnClickListener { openUrl(team.instagramUrl) }
        }
    }

    private fun openUrl(url: String) {
        val defaultBrowser =
            Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
        defaultBrowser.data = Uri.parse(url)
        startActivity(defaultBrowser)
    }
}