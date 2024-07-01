package com.example.draftstreaks.ui.joinContest.fragment.scoreBoard.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.clickInterface.PlayerClickListener
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.ListScoreboardBinding
import com.example.draftstreaks.ui.joinContest.activity.Scoreboard.ScoreBoardActivity
import com.example.draftstreaks.ui.joinContest.fragment.scoreBoard.ScoreBoardTableFragment
import com.example.draftstreaks.ui.joinContest.fragment.teamFragment.TeamFragment

class ScoreBoardAdapter (var activity: ScoreBoardActivity, ) : RecyclerView.Adapter<ScoreBoardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ListScoreboardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor", "SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

holder.binding.root.setOnClickListener{
    activity.scoreboardScreenType = ScreenConstant.scoreBoardTable
    activity.openFragment(ScoreBoardTableFragment(),ScreenConstant.scoreBoardTable)
}

    }

    override fun getItemCount() = 10

    inner class ViewHolder(var binding: ListScoreboardBinding) : RecyclerView.ViewHolder(binding.root)
}