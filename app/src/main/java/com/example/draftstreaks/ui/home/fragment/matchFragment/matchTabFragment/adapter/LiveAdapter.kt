package com.example.draftstreaks.ui.home.fragment.matchFragment.matchTabFragment.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.databinding.ListLiveMatchBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.ui.home.activtiy.homeActivity.HomeActivity
import com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.adapter.PlayersListAdapter
import com.example.draftstreaks.ui.joinContest.activity.Scoreboard.ScoreBoardActivity

class LiveAdapter(var activity: HomeActivity, var matchData:ArrayList<LeagueModel>):
    RecyclerView.Adapter<LiveAdapter.ViewHolder>() {
    lateinit var leagueModel:  ArrayList<LeagueModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListLiveMatchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matchData[position]
        leagueModel = getLeagueModel()
        holder.binding.subLiveRecyclerLeague.adapter = PlayersListAdapter(activity,leagueModel)
        holder.binding.subLiveRecyclerLeague.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        holder.binding.subLiveRecyclerLeague.setHasFixedSize(true)
        holder.binding.root.setOnClickListener{
            activity.startActivity(Intent(activity,ScoreBoardActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return matchData.size
    }
    inner class ViewHolder(val binding: ListLiveMatchBinding): RecyclerView.ViewHolder(binding.root)
}