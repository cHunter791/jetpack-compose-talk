package com.chunter.composetalk

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(R.layout.activity_main), Navigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.fragment_container)
                addToBackStack("main")
            }
        }
    }

    override fun navigateToDetail(team: Team, sharedViews: List<View>) {
        val bundle = bundleOf("team" to team)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            sharedViews.forEach { view ->
                addSharedElement(view, "badge")
            }
            replace(R.id.fragment_container, DetailFragment::class.java, bundle)
            addToBackStack("detail")
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            return false
        }

        return super.onSupportNavigateUp()
    }
}