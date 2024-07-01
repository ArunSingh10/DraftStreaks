package com.example.draftstreaks.ui.home.fragment.winnerFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentSupportBinding
import com.example.draftstreaks.databinding.FragmentWinnerBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.ui.home.fragment.winnerFragment.adapter.WinnerAdpater
import com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.prizePoolTab.WinningAdapter
import com.example.draftstreaks.utility.Utils
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabGravity

class WinnerFragment : Fragment() {
    lateinit var binding: FragmentWinnerBinding
    lateinit var mActivity: HomeActivity
    lateinit var winnerAdapter: WinnerAdpater
    private val tabIcons = intArrayOf(
        R.drawable.basketball_tab_image,
        R.drawable.rugby_white_img
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_winner, container, false)
        mActivity = activity as HomeActivity
        mActivity.binding.layoutToolBar.visibility = View.GONE
        mActivity.binding.layoutCenterToolText.visibility = View.GONE
        mActivity.binding.toolBarProfiles.visibility = View.VISIBLE
        mActivity.binding.parentToolBarLogo.visibility = View.VISIBLE
        mActivity.binding.parentImagebell.visibility = View.VISIBLE
        mActivity.binding.parentImageWallets.visibility = View.VISIBLE
        checkAppPermission()
        return binding.root
    }

    private fun checkAppPermission() {

        if (!NetworkUtils.isInternetAvailable(mActivity)) {
            Utils.showNetworkLostAlertDialog(mActivity, "No Internet Available")
            {
                checkAppPermission()
            }
        } else {
          loadWinnerPager()
        }
    }

    private fun loadWinnerPager() {

        binding.winnerTabLayout.tabGravity = TabLayout.GRAVITY_FILL
        winnerAdapter = WinnerAdpater(childFragmentManager)
        binding.winnerViewPager.adapter = winnerAdapter
        binding.winnerTabLayout.setupWithViewPager(binding.winnerViewPager)
        setupTabIcons()

    }

    private fun setupTabIcons() {
        binding.winnerTabLayout.getTabAt(0)?.setIcon(tabIcons.get(0))
        binding.winnerTabLayout.getTabAt(1)?.setIcon(tabIcons.get(1))
    }
}