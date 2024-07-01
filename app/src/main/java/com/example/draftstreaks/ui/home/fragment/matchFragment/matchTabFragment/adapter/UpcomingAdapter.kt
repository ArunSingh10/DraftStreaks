package com.example.draftstreaks.ui.home.fragment.matchFragment.matchTabFragment.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.ListUpcomingBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.adapter.PlayersListAdapter
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity

class UpcomingAdapter (var activity: FragmentActivity, var matchData:ArrayList<LeagueModel>):
    RecyclerView.Adapter<UpcomingAdapter.ViewHolder>() {
    lateinit var leagueModel:  ArrayList<LeagueModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListUpcomingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matchData[position]
        leagueModel = getLeagueModel()

        holder.binding.subRecyclerLeague.adapter = PlayersListAdapter(activity,leagueModel)
        holder.binding.subRecyclerLeague.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        holder.binding.subRecyclerLeague.setHasFixedSize(true)
holder.binding.root.setOnClickListener {

    activity.startActivity(Intent(activity,JoinContestActivity::class.java))
    ScreenConstant.joinContestScreenType = ScreenConstant.joinContest

}
    }

    override fun getItemCount(): Int {
        return matchData.size
    }
    inner class ViewHolder(val binding: ListUpcomingBinding): RecyclerView.ViewHolder(binding.root)
}