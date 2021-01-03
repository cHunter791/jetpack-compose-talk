package com.chunter.composetalk

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import coil.load
import coil.request.ImageRequest
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailFragment : Fragment(R.layout.fragment_detail) {

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

        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)

        initViews(view)

        requireArguments().getParcelable<Team>("team")?.let { team ->
            setupUI(team)
        }
    }

    private fun initViews(view: View) {
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