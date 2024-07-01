package com.example.draftstreaks.ui.joinContest.fragment.createLeague

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.FragmentCreateLeagueBinding
import com.example.draftstreaks.ui.joinContest.activity.createLeagueActivity.CreateLeagueActivity

import com.example.draftstreaks.utility.Utils.Companion.setupToolbar
import com.google.android.material.tabs.TabLayout


class CreateLeagueFragment : Fragment() {
    lateinit var binding: FragmentCreateLeagueBinding
    lateinit var mActivity: CreateLeagueActivity
    lateinit var createLeagueAdapter: CreateLeagueAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_league, container, false)
        mActivity = activity as CreateLeagueActivity

        loadCreateLeagueScreen()
        return binding.root
    }

    private fun loadCreateLeagueScreen() {
        if (ScreenConstant.tabPosition==1){

            binding.createLeagueTabLayout.tabGravity = TabLayout.GRAVITY_FILL
            createLeagueAdapter = CreateLeagueAdapter(childFragmentManager)
            binding.createLeagueViewPager.adapter = createLeagueAdapter
            binding.createLeagueTabLayout.setupWithViewPager(binding.createLeagueViewPager)
            binding.createLeagueTabLayout.getTabAt(1)!!.select()
        }else{

            binding.createLeagueTabLayout.tabGravity = TabLayout.GRAVITY_FILL
            createLeagueAdapter = CreateLeagueAdapter(childFragmentManager)
            binding.createLeagueViewPager.adapter = createLeagueAdapter
            binding.createLeagueTabLayout.setupWithViewPager(binding.createLeagueViewPager)
            binding.createLeagueTabLayout.getTabAt(0)!!.select()
        }
    }
}