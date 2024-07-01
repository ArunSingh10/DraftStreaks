package com.example.draftstreaks.ui.home.fragment.homeFragment.gamesTabFragment.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.R
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.ListContestRecyclerBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.localModel.getLeagueModel
import com.example.draftstreaks.ui.joinContest.activity.JoinContestActivity

class LeagueAdapter(var activity: FragmentActivity,var matchData:ArrayList<LeagueModel>,var tabScreen:String):RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {
    lateinit var leagueModel:  ArrayList<LeagueModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListContestRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
      return  ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matchData[position]
        leagueModel = getLeagueModel()
        holder.binding.pricePool.text=match.pricePool
    holder.binding.root.setOnClickListener{
        activity.startActivity( Intent(activity,JoinContestActivity::class.java) )
    }
        if (tabScreen ==ScreenConstant.isFootball){
            holder.binding.imageDraft.setImageResource(R.drawable.image_nfl_draft)
            holder.binding.textSportsType.text = "NFL Mock Draft 2024"
        }else{
            holder.binding.imageDraft.setImageResource(R.drawable.image_draft_nba)
        }

    }

    override fun getItemCount(): Int {
     return 1
    }
    inner class ViewHolder(val binding:ListContestRecyclerBinding):RecyclerView.ViewHolder(binding.root)
}