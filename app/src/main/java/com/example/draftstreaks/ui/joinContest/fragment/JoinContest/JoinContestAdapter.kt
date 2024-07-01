package com.example.draftstreaks.ui.joinContest.fragment.JoinContest

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.AllContestsFragment
import com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.MyContestsFragment
import com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.MyDraftFragment

class JoinContestAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm!!) {


    @SuppressLint("SuspiciousIndentation")
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> {
                fragment = AllContestsFragment()

            }

            1 -> {
                fragment = MyContestsFragment()

            }

            2 -> {
                fragment = MyDraftFragment()

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
                title = "Contests"
            }

            1 -> {
                title = "My Contest"
            }

            2 -> {
                title = "My Draft"
            }
        }
        return title

    }
}
