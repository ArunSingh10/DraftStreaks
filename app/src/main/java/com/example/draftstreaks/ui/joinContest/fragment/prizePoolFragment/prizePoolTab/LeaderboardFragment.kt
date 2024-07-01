package com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.prizePoolTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentLeaderboardBinding
import com.example.draftstreaks.databinding.FragmentWinningsBinding
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity


class LeaderboardFragment : Fragment() {
    lateinit var binding: FragmentLeaderboardBinding
    lateinit var mActivity: PrizePoolActivity
    lateinit var leaderboardAdapter: LeaderBoardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_leaderboard, container, false)
        mActivity = activity as PrizePoolActivity

        loadScreen()
        return binding.root
    }

    private fun loadScreen() {
        leaderboardAdapter = LeaderBoardAdapter(mActivity)
        binding.recyclerLeaderboard.adapter = leaderboardAdapter
        binding.recyclerLeaderboard.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerLeaderboard.setHasFixedSize(true)
    }


}