package com.chunter.composetalk

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val teamList: RecyclerView = view.findViewById(R.id.team_list)
        val teamAdapter = TeamsAdapter(::onItemSelected)
        teamList.adapter = teamAdapter
        lifecycleScope.launchWhenResumed {
            teamAdapter.submitList(DataLoader.getTeams())
        }
    }

    private fun onItemSelected(team: Team, sharedViews: List<View>) {
        (requireActivity() as Navigator).navigateToDetail(team, sharedViews)
    }
}