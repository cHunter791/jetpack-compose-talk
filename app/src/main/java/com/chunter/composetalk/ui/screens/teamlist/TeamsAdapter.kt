package com.chunter.composetalk.ui.screens.teamlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chunter.composetalk.R
import com.chunter.composetalk.data.Team
import com.chunter.composetalk.ui.components.TeamRow

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
        val team = teams[position]

        val teamRow = holder.itemView.findViewById<TeamRow>(R.id.team_row_view)
        teamRow.setData(team)
        teamRow.setOnClickListener { onClickListener(team) }
    }

    override fun getItemCount(): Int = teams.size

    fun submitList(teams: List<Team>) {
        this.teams = teams
        notifyDataSetChanged()
    }
}