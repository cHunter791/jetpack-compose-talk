package com.chunter.composetalk.ui.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chunter.composetalk.data.DataLoader
import com.chunter.composetalk.data.Team
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val _state: MutableLiveData<ViewState> = MutableLiveData(ViewState())
    val state: LiveData<ViewState>
        get() = _state

    fun getTeam(id: Int) {
        viewModelScope.launch {
            _state.value = _state.value?.copy(team = DataLoader.getTeam(id))
        }
    }

    data class ViewState(
        val team: Team? = null
    )
}