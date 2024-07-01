package com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.prizePoolTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentCreateLeagueBinding
import com.example.draftstreaks.databinding.FragmentWinningsBinding
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity
import com.example.draftstreaks.ui.joinContest.fragment.createLeague.CreateLeagueAdapter
import com.google.android.material.tabs.TabLayout

class WinningsFragment : Fragment() {

    lateinit var binding: FragmentWinningsBinding
    lateinit var mActivity: PrizePoolActivity
    lateinit var  winningsAdapter: WinningAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{


        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_winnings, container, false)
        mActivity = activity as PrizePoolActivity

        loadScreen()
        return binding.root
    }
    fun loadScreen() {

        winningsAdapter = WinningAdapter(mActivity)
        binding.winRecycler.adapter = winningsAdapter
        binding.winRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.winRecycler.setHasFixedSize(true)
    }
}