package com.example.draftstreaks.ui.home.fragment.MockDraftFragment.adapter

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.draftstreaks.ui.home.fragment.MockDraftFragment.mockDraftTab.LeaderboardDraftFragment
import com.example.draftstreaks.ui.home.fragment.MockDraftFragment.mockDraftTab.WinningsDraftFragment

class MockDraftTabAdapter(
    fm: FragmentManager?
) : FragmentStatePagerAdapter(fm!!) {


    @SuppressLint("SuspiciousIndentation")
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> {
                fragment = WinningsDraftFragment()
            }

            1 -> {
                fragment = LeaderboardDraftFragment()
            }
        }

        return fragment!!
    }

    override fun getCount(): Int {
        return 2
    }

    @SuppressLint("SuspiciousIndentation")
    override fun getPageTitle(position: Int): String? {
        var title: String? = null
        when (position) {
            0 -> {
                title = "Winnings"
            }
            1 -> {
                title = "Leaderboard"
            }
        }
        return title

    }
}
