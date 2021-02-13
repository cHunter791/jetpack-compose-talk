package com.chunter.composetalk.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.chunter.composetalk.R
import com.chunter.composetalk.openUrl

@Composable
fun SocialMediaButton(
    url: String,
    @DrawableRes res: Int
) {
    val context = LocalContext.current
    FloatingActionButton(onClick = { openUrl(context, url) }) {
        Icon(painter = painterResource(id = res), null)
    }
}

@Preview
@Composable
fun SocialMediaButtonPreview() {
    SocialMediaButton("", R.drawable.ic_website)
}