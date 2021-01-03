package com.chunter.composetalk

import android.view.View

interface Navigator {

    fun navigateToDetail(team: Team, sharedViews: List<View>)
}