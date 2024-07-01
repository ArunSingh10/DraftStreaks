package com.example.draftstreaks.ui.home.fragment.MockDraftFragment.mockDraftTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentLeaderboardDraftBinding
import com.example.draftstreaks.ui.home.activtiy.mockDraftActivity.MockDratfActivity
import com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.prizePoolTab.LeaderBoardAdapter


class LeaderboardDraftFragment : Fragment() {
    lateinit var binding: FragmentLeaderboardDraftBinding
    lateinit var mActivity: MockDratfActivity
    lateinit var leaderboardAdapter: LeaderBoardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_leaderboard_draft, container, false)
        mActivity = activity as MockDratfActivity

        loadScreen()
        return binding.root
    }

    private fun loadScreen() {
        leaderboardAdapter = LeaderBoardAdapter(mActivity)
        binding.recyclerDraftLeaderboard.adapter = leaderboardAdapter
        binding.recyclerDraftLeaderboard.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerDraftLeaderboard.setHasFixedSize(true)
    }

}