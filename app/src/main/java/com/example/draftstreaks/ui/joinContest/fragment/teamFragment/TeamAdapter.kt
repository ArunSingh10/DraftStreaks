package com.example.draftstreaks.ui.joinContest.fragment.teamFragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.draftstreaks.clickInterface.PlayerClickListener
import com.example.draftstreaks.constant.ScreenConstant
import com.example.draftstreaks.databinding.ListRecyclerTeamFragmentBinding
import com.example.draftstreaks.localModel.TeamModel
import com.example.draftstreaks.ui.joinContest.activity.PrizePoolActivity

class TeamAdapter(
    var activity: PrizePoolActivity,val fragment:TeamFragment
) : RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    var onClickListener: PlayerClickListener? = null
    var teamModel: List<TeamModel> = emptyList()
    var isSelect = false

    fun setClickListener(onClickListener: PlayerClickListener) {
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ListRecyclerTeamFragmentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor", "SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val showSelected = teamModel[position]



        if (showSelected.isSelect==true){
                holder.binding.layoutSelectPlayer.setBackgroundColor(Color.parseColor("#305763"))
                holder.binding.imageRadioButtonPlayerName.visibility = View.VISIBLE
                holder.binding.textPick1.text = showSelected.textNumber
                holder.binding.textPlayerName.text = showSelected.playerName
                holder.binding.imageTeamFlag.setImageResource(showSelected.clubImage)
        }

        else{
            holder.binding.layoutSelectPlayer.setBackgroundColor(Color.TRANSPARENT)
            holder.binding.imageRadioButtonPlayerName.visibility = View.GONE
            holder.binding.textPick1.text = showSelected.textNumber
            holder.binding.textPlayerName.text = showSelected.playerName
            holder.binding.imageTeamFlag.setImageResource(showSelected.clubImage)
        }

        holder.binding.root.setOnClickListener { v ->

            isSelect = showSelected.isSelect
            onClickListener!!.onTeamSelectClick(position)

        }
    }

    override fun getItemCount() = teamModel.size

    inner class ViewHolder(var binding: ListRecyclerTeamFragmentBinding) :
        RecyclerView.ViewHolder(binding.root)
}