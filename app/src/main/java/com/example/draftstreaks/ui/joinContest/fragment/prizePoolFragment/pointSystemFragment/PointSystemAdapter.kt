package com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.pointSystemFragment

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.BasketBallFragment
import com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.FootBallFragment
import com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.pointSystemFragment.pointSystemTab.BasketballPointSystemFragment
import com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.pointSystemFragment.pointSystemTab.FootballPointSystemFragment

class PointSystemAdapter (
    fm: FragmentManager?
)  : FragmentStatePagerAdapter(fm!!) {


    @SuppressLint("SuspiciousIndentation")
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> {
                fragment = BasketballPointSystemFragment()
            }

            1 -> {
                fragment = FootballPointSystemFragment()
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
                title = "Basketball"
            }
            1 -> {
                title ="Football"
            }
        }
        return title

    }
}
