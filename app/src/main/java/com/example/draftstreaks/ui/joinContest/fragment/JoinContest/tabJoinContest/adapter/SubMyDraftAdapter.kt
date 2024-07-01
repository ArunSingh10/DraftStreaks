package com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ListSubChildMycontestBinding
import com.example.draftstreaks.databinding.ListSubMyDraftBinding
import com.example.draftstreaks.localModel.LeagueModel

class SubMyDraftAdapter (var activity: FragmentActivity, var matchData:ArrayList<LeagueModel>):
    RecyclerView.Adapter<SubMyDraftAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListSubMyDraftBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matchData[position]

    }


    override fun getItemCount(): Int {
        return minOf( matchData.size, 10)
    }

    inner class ViewHolder(val binding: ListSubMyDraftBinding): RecyclerView.ViewHolder(binding.root)
}