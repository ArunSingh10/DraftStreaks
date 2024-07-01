package com.example.draftstreaks.ui.home.fragment.matchFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentMatchesBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.ui.joinContest.fragment.JoinContest.JoinContestAdapter
import com.example.draftstreaks.utility.Utils
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabGravity


class MatchesFragment : Fragment() {

    lateinit var binding: FragmentMatchesBinding
    lateinit var mActivity: HomeActivity
    lateinit var matchAdapter:MatchesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_matches, container, false)
        mActivity = activity as HomeActivity
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
            mActivity.binding.layoutToolBar.visibility = View.VISIBLE
            mActivity.binding.toolBarProfiles.visibility = View.GONE
            mActivity.binding.parentToolBarLogo.visibility = View.GONE
            mActivity.binding.parentImagebell.visibility = View.GONE
            mActivity.binding.parentImageWallets.visibility = View.GONE
            loadMokeDraft()
        }
    }

    private fun loadMokeDraft() {

        binding.mokeDraftMatchTabLayout.tabGravity = TabLayout.GRAVITY_FILL
        matchAdapter = MatchesAdapter(childFragmentManager)
        binding.mokeDraftViewPager.adapter = matchAdapter
        binding.mokeDraftMatchTabLayout.setupWithViewPager(binding.mokeDraftViewPager)

    }

    override fun onResume() {
        super.onResume()
        checkAppPermission()
    }

}