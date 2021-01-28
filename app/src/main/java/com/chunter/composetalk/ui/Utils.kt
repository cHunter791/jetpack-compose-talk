package com.chunter.composetalk.ui

import android.content.Context
import android.content.Intent
import android.content.res.Resources.getSystem
import android.net.Uri

fun Context.openUrl(url: String) {
    val defaultBrowser =
        Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
    defaultBrowser.data = Uri.parse(url)
    startActivity(defaultBrowser)
}

val Int.dp: Int get() = (this / getSystem().displayMetrics.density).toInt()
