package com.example.draftstreaks.ui.joinContest.fragment.JoinContest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.FragmentJoinContestBinding
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity
import com.example.draftstreaks.ui.joinContest.activity.createLeagueActivity.CreateLeagueActivity
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar
import com.google.android.material.tabs.TabLayout


class JoinContestFragment : Fragment(),View.OnClickListener {
 lateinit var binding:FragmentJoinContestBinding
 lateinit var contestAdapter: JoinContestAdapter
 lateinit var mActivity:JoinContestActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding=DataBindingUtil.inflate(inflater,R.layout.fragment_join_contest, container, false)
        mActivity = activity as JoinContestActivity
        loadPage()
        return binding.root
    }

    private fun loadPage() {


        loadContests()

    }

    private fun loadContests(){
        if (ScreenConstant.fromTabConfimationPosition == 1){
            binding.joinContestTabLayout.tabGravity = TabLayout.GRAVITY_FILL
            contestAdapter = JoinContestAdapter(childFragmentManager,)
            binding.contestViewPager.adapter = contestAdapter
            binding.joinContestTabLayout.setupWithViewPager(binding.contestViewPager)
            binding.joinContestTabLayout.getTabAt(1)!!.select()
            ScreenConstant.fromTabConfimationPosition = 0


        }else{
            binding.joinContestTabLayout.tabGravity = TabLayout.GRAVITY_FILL
            contestAdapter = JoinContestAdapter(childFragmentManager,)
            binding.contestViewPager.adapter = contestAdapter
            binding.joinContestTabLayout.setupWithViewPager(binding.contestViewPager)
            binding.joinContestTabLayout.getTabAt(0)!!.select()



        }


    }

    override fun onClick(p0: View?) {
        when(p0!!.id){

        }
    }


}