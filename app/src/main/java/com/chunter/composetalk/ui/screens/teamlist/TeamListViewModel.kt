package com.chunter.composetalk.ui.screens.teamlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chunter.composetalk.data.DataLoader
import com.chunter.composetalk.data.Team
import kotlinx.coroutines.launch

class TeamListViewModel : ViewModel() {

    private val _state: MutableLiveData<ViewState> = MutableLiveData(ViewState())
    val state: LiveData<ViewState>
        get() = _state

    init {
        viewModelScope.launch {
            _state.value = _state.value?.copy(teams = DataLoader.getTeams())
        }
    }

    data class ViewState(
        val teams: List<Team> = emptyList()
    )
}