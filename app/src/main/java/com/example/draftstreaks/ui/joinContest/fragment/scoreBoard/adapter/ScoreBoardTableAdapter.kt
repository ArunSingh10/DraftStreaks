package com.example.draftstreaks.ui.joinContest.fragment.scoreBoard.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ListScoreboardTableBinding
import com.example.draftstreaks.databinding.ListWinRecyclerBinding

class ScoreBoardTableAdapter  (var activity: Activity):
    RecyclerView.Adapter<ScoreBoardTableAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScoreBoardTableAdapter.ViewHolder {
        val binding  = ListScoreboardTableBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ScoreBoardTableAdapter.ViewHolder, position: Int) {

        if (position % 2 == 0) {
            holder.binding.root.setBackgroundColor(
                ContextCompat.getColor( holder.itemView.context,  R.color.colorPrimaryDark))
        } else {
            holder.binding.root.setBackgroundColor(
                ContextCompat.getColor( holder.itemView.context,  R.color.colorDeepSlateGray))
        }
    }

    override fun getItemCount() = 10
    inner class ViewHolder(var binding: ListScoreboardTableBinding): RecyclerView.ViewHolder(binding.root)
}