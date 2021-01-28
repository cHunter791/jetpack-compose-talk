package com.chunter.composetalk.ui.components

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import androidx.core.view.updateLayoutParams
import coil.load
import com.chunter.composetalk.R
import com.chunter.composetalk.data.Team

class TeamRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val badgeImage: ImageView
    private val teamNameText: TextView
    private val alternateNameText: TextView

    private var badgeSize: Int = 40

    init {
        val view = inflate(context, R.layout.custom_team_row, this)

        context.withStyledAttributes(attrs, R.styleable.TeamRow) {
            badgeSize = getDimension(R.styleable.TeamRow_badgeSize, 40f).toInt()
        }

        badgeImage = view.findViewById(R.id.team_badge_image)
        teamNameText = view.findViewById(R.id.team_name_text)
        alternateNameText = view.findViewById(R.id.team_name_alternate_text)

        badgeImage.updateLayoutParams {
            width = badgeSize
            height = badgeSize
        }
    }

    fun setData(team: Team) {
        badgeImage.load(team.badgeUrl)
        teamNameText.text = team.name
        alternateNameText.text = team.alternateName
    }
}