package com.chunter.composetalk.ui.components

import android.content.Context
import android.util.AttributeSet
import com.chunter.composetalk.ui.util.openUrl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SocialMediaButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = com.google.android.material.R.attr.floatingActionButtonStyle
) : FloatingActionButton(
    context, attrs, defStyleAttr
) {

    fun setUrl(url: String) {
        setOnClickListener { context.openUrl(url) }
    }
}