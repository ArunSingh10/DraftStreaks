package com.example.draftstreaks.ui.joinContest.fragment.scoreBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.FragmentScoreBoardBinding
import com.example.draftstreaks.ui.joinContest.activity.Scoreboard.ScoreBoardActivity
import com.example.draftstreaks.ui.joinContest.fragment.scoreBoard.adapter.ScoreBoardAdapter
import com.example.draftstreaks.utility.Utils.Companion.setupToolbar


class ScoreBoardFragment : Fragment() {
lateinit var binding:FragmentScoreBoardBinding
lateinit var mActivity:ScoreBoardActivity
lateinit var scoreboardAdapter: ScoreBoardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_score_board, container, false)
        mActivity = activity as ScoreBoardActivity
        mActivity.setupToolbar(binding.includeToolbar.toolbar, binding.includeToolbar.textViewToolbarTitle, "ScoreBoard", R.drawable.back_arrow) { mActivity.finish() }
        loadPage()
        return binding.root
    }

    private fun loadPage() {
        scoreboardAdapter = ScoreBoardAdapter(mActivity)
        binding.recycleScoreBoard.adapter = scoreboardAdapter
        binding.recycleScoreBoard.layoutManager = LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false)
        binding.recycleScoreBoard.setHasFixedSize(true)


    }

}