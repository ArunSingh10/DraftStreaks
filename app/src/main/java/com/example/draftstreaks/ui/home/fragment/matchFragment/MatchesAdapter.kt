package com.example.draftstreaks.ui.home.fragment.matchFragment

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.draftstreaks.ui.home.fragment.matchFragment.matchTabFragment.CompletedDraftFragment
import com.example.draftstreaks.ui.home.fragment.matchFragment.matchTabFragment.LiveDraftFragment
import com.example.draftstreaks.ui.home.fragment.matchFragment.matchTabFragment.UpcomingDraftFragment


class MatchesAdapter (
    fm: FragmentManager?
) : FragmentStatePagerAdapter(fm!!) {


    @SuppressLint("SuspiciousIndentation")
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> {
                fragment = UpcomingDraftFragment()
            }

            1 -> {
                fragment = LiveDraftFragment()
            }

            2 -> {
                fragment = CompletedDraftFragment()
            }
        }

        return fragment!!
    }

    override fun getCount(): Int {
        return 3
    }


    @SuppressLint("SuspiciousIndentation")
    override fun getPageTitle(position: Int): String? {
        var title: String? = null
        when (position) {
            0 -> {
                title = "Upcoming"
            }

            1 -> {
                title = "Live"
            }

            2 -> {
                title = "Completed"
            }
        }
        return title

    }
}