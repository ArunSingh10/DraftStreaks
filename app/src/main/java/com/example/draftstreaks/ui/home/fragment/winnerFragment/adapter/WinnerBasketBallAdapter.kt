package com.example.draftstreaks.ui.home.fragment.winnerFragment.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.databinding.ListContestRecyclerBinding
import com.example.draftstreaks.databinding.ListWinnerBasketFragmentBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.ui.home.activtiy.winnerDetailActivity.WinnerDetailActivity


class WinnerBasketBallAdapter(var activity: FragmentActivity):
    RecyclerView.Adapter<WinnerBasketBallAdapter.ViewHolder>() {
    lateinit var leagueModel:  ArrayList<LeagueModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListWinnerBasketFragmentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

   holder.binding.root.setOnClickListener{
       activity.startActivity(Intent(activity,WinnerDetailActivity::class.java))
   }
    }

    override fun getItemCount(): Int {
        return 10
    }
    inner class ViewHolder(val binding: ListWinnerBasketFragmentBinding): RecyclerView.ViewHolder(binding.root)
}