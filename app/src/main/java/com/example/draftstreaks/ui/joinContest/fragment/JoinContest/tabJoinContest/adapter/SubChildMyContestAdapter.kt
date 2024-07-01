package com.example.draftstreaks.ui.joinContest.fragment.JoinContest.tabJoinContest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.R
import com.example.draftstreaks.databinding.ListSubChildMycontestBinding
import com.example.draftstreaks.localModel.LeagueModel
import com.example.draftstreaks.ui.joinContest.activity.Scoreboard.ScoreBoardActivity

class SubChildMyContestAdapter(var activity: FragmentActivity, var matchData: List<LeagueModel>) :
    RecyclerView.Adapter<SubChildMyContestAdapter.ViewHolder>() {

   var displayedImages = matchData.take(6).toMutableList()
    private var allImagesDisplayed: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListSubChildMycontestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val match = displayedImages[position]

        when(position){
            5->{
                holder.binding.imageDraftListPlayer.setImageResource(match.icon)
                holder.binding.imageDraftListPlayer.setBackgroundResource(R.color.colorPrimaryDarkTransperent)
                holder.binding.imageDraftListPlayer.alpha = 0.5f
                holder.binding.textRemaingImages.visibility = View.VISIBLE
                var remainPlayer = matchData.size.minus(displayedImages.size).toString()
                holder.binding.textRemaingImages.text = "+$remainPlayer"



            }else->{
                holder.binding.imageDraftListPlayer.setImageResource(match.icon)
            holder.binding.textRemaingImages.visibility = View.GONE

            }
        }

        if (position == 5 && !allImagesDisplayed ){
            holder.binding.imageDraftListPlayer.setOnClickListener{
                updateData(matchData)
                allImagesDisplayed = true
                holder.binding.imageDraftListPlayer.setBackgroundResource(R.color.colorTransparent)
                holder.binding.imageDraftListPlayer.alpha = 1f
                holder.binding.textRemaingImages.visibility = View.GONE

              /*  activity.startActivity(Intent(activity,ScoreBoardActivity::class.java))*/
            }
        }
    }

    override fun getItemCount(): Int {
        return  displayedImages.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newImages: List<LeagueModel>) {
        displayedImages.clear()
        displayedImages.addAll(newImages)
    }

    inner class ViewHolder(val binding: ListSubChildMycontestBinding) :
        RecyclerView.ViewHolder(binding.root)
}