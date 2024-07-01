package com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.pointSystemFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentPointSystemBinding
import com.example.draftstreaks.databinding.FragmentPrizePoolBinding

import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity

import com.example.draftstreaks.utility.Utils.Companion.setupToolbar
import com.google.android.material.tabs.TabLayout


class PointSystemFragment : Fragment() {
    lateinit var binding: FragmentPointSystemBinding
    lateinit var mActivity: PrizePoolActivity
    lateinit var pointSystemAdapter: PointSystemAdapter
    private val tabIcons = intArrayOf(
        R.drawable.image_basketball,
        R.drawable.rugby_white_img
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_point_system, container, false)
        mActivity = activity as PrizePoolActivity
        mActivity.setupToolbar(binding.includeToolbar.toolbar, binding.includeToolbar.textViewToolbarTitle, "Point System", R.drawable.back_arrow) { mActivity.finish() }
        loadScreen()
        return binding.root
    }

    private fun loadScreen() {

        binding.pointSystemTabLayout.tabGravity = TabLayout.GRAVITY_FILL
        pointSystemAdapter = PointSystemAdapter(childFragmentManager)
        binding.pointSystemViewPager.adapter = pointSystemAdapter
        binding.pointSystemTabLayout.setupWithViewPager(binding.pointSystemViewPager)
        setupTabIcons()
    }

    fun setupTabIcons() {
        binding.pointSystemTabLayout.getTabAt(0)?.setIcon(tabIcons.get(0))
        binding.pointSystemTabLayout.getTabAt(1)?.setIcon(tabIcons.get(1))

    }


}