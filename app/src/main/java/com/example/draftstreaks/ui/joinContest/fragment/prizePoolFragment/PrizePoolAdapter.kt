package com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.draftstreaks.ui.joinContest.fragment.createLeague.createLeagueTab.CustomLeagueFragment
import com.example.draftstreaks.ui.joinContest.fragment.createLeague.createLeagueTab.JoinLeagueFragment
import com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.prizePoolTab.LeaderboardFragment
import com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.prizePoolTab.WinningsFragment

class PrizePoolAdapter(
    fm: FragmentManager?
) : FragmentStatePagerAdapter(fm!!) {


    @SuppressLint("SuspiciousIndentation")
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> {
                fragment = WinningsFragment()
            }

            1 -> {
                fragment = LeaderboardFragment()
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
