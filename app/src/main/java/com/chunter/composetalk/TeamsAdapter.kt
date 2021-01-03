package com.chunter.composetalk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load

class TeamsAdapter(
    private val onClickListener: (Team, List<View>) -> Unit
) : ListAdapter<Team, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_team, parent, false)
        ) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = holder.itemView
        val team = getItem(position)

        val badgeImage: ImageView = view.findViewById(R.id.team_badge_image)
        ViewCompat.setTransitionName(badgeImage, "${team.id}_badge")
        badgeImage.load(team.badgeUrl)

        val nameText: TextView = view.findViewById(R.id.team_name_text)
        ViewCompat.setTransitionName(nameText, "${team.id}_name")
        nameText.text = team.name

        val alternateNameText: TextView = view.findViewById(R.id.team_name_alternate_text)
        ViewCompat.setTransitionName(alternateNameText, "${team.id}_alternate_name")
        alternateNameText.text = team.alternateName

        view.setOnClickListener {
            onClickListener(team, listOf(
                badgeImage
//                nameText,
//                alternateNameText
            ))
        }

    }

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<Team>() {
            override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}