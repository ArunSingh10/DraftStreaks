package com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.pointSystemFragment.pointSystemTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentBasketballPointSystemBinding
import com.example.draftstreaks.databinding.FragmentFootballPointSystemBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity
import com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.pointSystemFragment.StreaksAdapter


class FootballPointSystemFragment : Fragment() {

    lateinit var binding: FragmentFootballPointSystemBinding
    lateinit var mActivity: PrizePoolActivity
    lateinit var streaksAdapter: StreaksAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =DataBindingUtil.inflate(inflater,R.layout.fragment_football_point_system, container, false)

        mActivity = activity as PrizePoolActivity
        loadScreen()
        return binding.root
    }

    fun loadScreen() {
        val listStreaks = ArrayList<LeagueModel>()
        listStreaks.clear()
        listStreaks.add(LeagueModel(0, "Duck", "-3"))
        listStreaks.add(LeagueModel(0, "100 Runs", "25.00"))
        listStreaks.add(LeagueModel(0, "50 Runs", "10.00"))
        listStreaks.add(LeagueModel(0, "Six Run", "4.00"))
        listStreaks.add(LeagueModel(0, "Four Run", "2.00"))
        listStreaks.add(LeagueModel(0, "Run", "1.00"))
        streaksAdapter = StreaksAdapter(mActivity, listStreaks)
        binding.pointStreaksRecyclerFoot.adapter = streaksAdapter
        binding.pointStreaksRecyclerFoot.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.pointStreaksRecyclerFoot.setHasFixedSize(true)

        streaksAdapter = StreaksAdapter(mActivity, listStreaks)
        binding.pointBonussRecyclerFoot.adapter = streaksAdapter
        binding.pointBonussRecyclerFoot.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.pointBonussRecyclerFoot.setHasFixedSize(true)

    }
}