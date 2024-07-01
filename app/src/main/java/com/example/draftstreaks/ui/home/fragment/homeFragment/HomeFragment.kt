package com.example.draftstreaks.ui.home.fragment.homeFragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentHomeBinding
import com.example.draftstreaks.network.NetworkUtils
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.utility.Utils
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var mActivity: HomeActivity
    lateinit var gamesAdapter: GamesTabAdapter
    private val tabIcons = intArrayOf(
        R.drawable.basketball_tab_image,
        R.drawable.rugby_white_img
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        mActivity = activity as HomeActivity
        mActivity.binding.layoutToolBar.visibility = View.GONE
        mActivity.binding.toolBarProfiles.visibility = View.VISIBLE
        mActivity.binding.parentToolBarLogo.visibility = View.VISIBLE
        mActivity.binding.parentImagebell.visibility = View.VISIBLE
        mActivity.binding.parentImageWallets.visibility = View.VISIBLE
        mActivity.binding.layoutCenterToolText.visibility = View.GONE

        checkAppPermission()

        return binding.root
    }

    private fun checkAppPermission() {

        lifecycleScope.launch {
            if (!NetworkUtils.isInternetAvailable(mActivity)) {
                Utils.showNetworkLostAlertDialog(mActivity, "No Internet Available")
                {
                    checkAppPermission()
                }
            } else {
                loadPager()
            }
        }

    }
    private fun loadPager() {
        binding.contestTabLayout.tabGravity = TabLayout.GRAVITY_FILL
        gamesAdapter = GamesTabAdapter(childFragmentManager)
        binding.gamesViewPager.adapter = gamesAdapter
        binding.contestTabLayout.setupWithViewPager(binding.gamesViewPager)
        setupTabIcons()
    }

    fun setupTabIcons() {
        binding.contestTabLayout.getTabAt(0)?.setIcon(tabIcons.get(0))
        binding.contestTabLayout.getTabAt(1)?.setIcon(tabIcons.get(1))

    }

    override fun onResume() {
        super.onResume()
        binding.contestTabLayout.getTabAt(0)!!.select()
        checkAppPermission()
    }

}