package com.example.draftstreaks.ui.home.activtiy.winnerDetailActivity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.databinding.ListRecyclerWinnerDetailBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.adapter.PlayersListAdapter


class WinnerDetailAdapter  (var activity: FragmentActivity, ):
    RecyclerView.Adapter<WinnerDetailAdapter.ViewHolder>() {
    lateinit var leagueModel:  ArrayList<LeagueModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListRecyclerWinnerDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      //  val match = matchData[position]
        leagueModel = getLeagueModel()

        holder.binding.subWinnerDetailRecyclerLeague.adapter = PlayersListAdapter(activity,leagueModel)
        holder.binding.subWinnerDetailRecyclerLeague.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        holder.binding.subWinnerDetailRecyclerLeague.setHasFixedSize(true)

    }

    override fun getItemCount(): Int {
        return 2
    }
    inner class ViewHolder(val binding: ListRecyclerWinnerDetailBinding): RecyclerView.ViewHolder(binding.root)
}