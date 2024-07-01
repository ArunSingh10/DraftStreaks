package com.example.draftstreaks.ui.joinContest.fragment.prizePoolFragment.prizePoolTab

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ListRecyclerLeaderBoardBinding
import com.example.draftstreaks.databinding.ListWinRecyclerBinding

class LeaderBoardAdapter (var activity: Activity):
    RecyclerView.Adapter<LeaderBoardAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LeaderBoardAdapter.ViewHolder {
        val binding  = ListRecyclerLeaderBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LeaderBoardAdapter.ViewHolder, position: Int) {

      /*  if (position % 2 == 0) {
            holder.binding.root.setBackgroundColor(
                ContextCompat.getColor( holder.itemView.context,  R.color.colorDarkSlateGray))
        } else {
            holder.binding.root.setBackgroundColor(
                ContextCompat.getColor( holder.itemView.context,  R.color.colorDeepSlateGray))
        }*/
    }

    override fun getItemCount() = 5
    inner class ViewHolder(var binding: ListRecyclerLeaderBoardBinding): RecyclerView.ViewHolder(binding.root)
}