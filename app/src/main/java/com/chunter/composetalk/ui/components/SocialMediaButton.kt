package com.chunter.composetalk.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.chunter.composetalk.R
import com.chunter.composetalk.openUrl

@Composable
fun SocialMediaButton(
    url: String,
    @DrawableRes res: Int
) {
    val context = AmbientContext.current
    FloatingActionButton(onClick = { openUrl(context, url) }) {
        Icon(imageVector = vectorResource(id = res))
    }
}

@Preview
@Composable
fun SocialMediaButtonPreview() {
    SocialMediaButton("", R.drawable.ic_website)
}