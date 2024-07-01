package com.example.draftstreaks.ui.joinContest.fragment.createLeague

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.draftstreaks.ui.joinContest.fragment.createLeague.createLeagueTab.CustomLeagueFragment
import com.example.draftstreaks.ui.joinContest.fragment.createLeague.createLeagueTab.JoinLeagueFragment

class CreateLeagueAdapter(
    fm: FragmentManager?
) : FragmentStatePagerAdapter(fm!!) {


    @SuppressLint("SuspiciousIndentation")
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {

            0 -> {
                fragment = CustomLeagueFragment()
            }

            1 -> {
                fragment = JoinLeagueFragment()
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
                title = "Custom Contest"
            }

            1 -> {
                title = "Join Contest"
            }

        }
        return title

    }
}
