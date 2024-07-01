package com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.databinding.ListPlayerLeagueBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.ui.joinContest.activity.Scoreboard.ScoreBoardActivity

class PlayersListAdapter (var activity: FragmentActivity, var playerList:ArrayList<LeagueModel>):
    RecyclerView.Adapter<PlayersListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListPlayerLeagueBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = playerList[position]
     holder.binding.playerImage.setImageResource(player.icon)

    }


    override fun getItemCount(): Int {
        return playerList.size
    }
    inner class ViewHolder(val binding: ListPlayerLeagueBinding): RecyclerView.ViewHolder(binding.root)
}