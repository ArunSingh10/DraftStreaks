package com.example.draftstreaks.ui.home.fragment.winnerFragment.adapter

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.draftstreaks.ui.home.fragment.winnerFragment.winnerTabFragment.WinnerBasketBallFragment
import com.example.draftstreaks.ui.home.fragment.winnerFragment.winnerTabFragment.WinnerFootBallFragment

class WinnerAdpater  (
    fm: FragmentManager?
)  : FragmentStatePagerAdapter(fm!!) {


    @SuppressLint("SuspiciousIndentation")
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> {
                fragment = WinnerBasketBallFragment()
            }

            1 -> {
                fragment = WinnerFootBallFragment()
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
