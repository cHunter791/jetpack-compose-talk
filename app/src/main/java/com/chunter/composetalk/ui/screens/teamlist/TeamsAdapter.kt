package com.chunter.composetalk.ui.screens.teamlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.chunter.composetalk.R
import com.chunter.composetalk.data.Team

class TeamsAdapter(
    private val onClickListener: (Team) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var teams: List<Team> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_team, parent, false)
        ) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = holder.itemView
        val team = teams[position]

        val badgeImage: ImageView = view.findViewById(R.id.team_badge_image)
        ViewCompat.setTransitionName(badgeImage, "${team.id}_badge")
        badgeImage.load(team.badgeUrl)

        val nameText: TextView = view.findViewById(R.id.team_name_text)
        ViewCompat.setTransitionName(nameText, "${team.id}_name")
        nameText.text = team.name

        val alternateNameText: TextView = view.findViewById(R.id.team_name_alternate_text)
        ViewCompat.setTransitionName(alternateNameText, "${team.id}_alternate_name")
        alternateNameText.text = team.alternateName

        view.setOnClickListener { onClickListener(team) }
    }

    override fun getItemCount(): Int = teams.size

    fun submitList(teams: List<Team>) {
        this.teams = teams
        notifyDataSetChanged()
    }
}