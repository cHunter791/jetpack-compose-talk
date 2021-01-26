package com.chunter.composetalk.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.chunter.composetalk.R
import com.chunter.composetalk.data.Team

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val teamList: RecyclerView = view.findViewById(R.id.team_list)
        val teamAdapter = TeamsAdapter(::onItemSelected)
        teamList.adapter = teamAdapter

        viewModel.state.observe(viewLifecycleOwner) { state ->
            teamAdapter.submitList(state.teams)
        }
    }

    private fun onItemSelected(team: Team) {
        findNavController().navigate(
            R.id.action_mainFragment_to_detailFragment,
            bundleOf("teamId" to team.id)
        )
    }
}